/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import dealer_.Selling.Dealer;
import dealer_.Service.ServiceEmployee;
import interfaces.Frame;
import interfaces.Vehicle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import userInterface.service.Report;
import userInterface.dealer.DealerParam;
import userInterface.dealer.Register;
import userInterface.user.UserInformation;
import vehicle.Car;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import person.Client;
import person.CreditCard;
import person.Date;
import person.bank.Credit;
import userInterface.dealer.userInterface.DealerCarResult; 
import userInterface.user.UserMenu;

public class SqlFrontController implements Frame{
    /**
     * <div>
     *     <h1>CreditCard</h1>
     *     <div>
     *         <p>For the present credit car and user are
     *         in the database while dealer is in a local file.
     *         However both of them can be held in database,and
     *         bank registry and interest etc. can be generated.
     *         Opening up local database in necessary for functioning
     *         of the project,and this can be done by installing XAMPP.
     *         For this, application needs to be installed.And you can carry
     *         out installing with inside</p>
     *     </div>
     * </div>
     */
    public boolean flag=true;
    private ArrayList<Car> result; 
    private ArrayList<Dealer>dealers=new ArrayList<>();
    private JFrame oldFrame;
    private ArrayList<DealerParam> results; 
    private DealerParam dealerParam;
    private Client client=null;
    private Connection con;
    private ResultSet rs;
    private Statement statement = null;
    private static SqlFrontController sfc;
    private String name; 
    private String bornDay; 
    private CreditCard card;
    private PreparedStatement preparedStatement = null;
    private Vehicle vehicle;
    private Report report;
    public SqlFrontController getSqlFrontController(){
        if(sfc==null)
            sfc=new SqlFrontController();
        return sfc;
    }
    public void command(String command){
        switch(command.toLowerCase()){
            case "insertuser":
                insertUser();
                break;
            case "insertcard":
                insertCard();
                break;
            case "delete":
                delete();
                break;
            case "select":
                select();
                break;
            case "connect":
                connect();
                break;
            case "insertdealer":
                insertDealer();
                break;
            case "selectdealer":
                selectDealer();
                break;
            case "updatedealer":
                dealerUpdate();
                break;
            case "getdealers":
                getDealersFromDatabase();
                break;
            case "writecarscsv":
                carsToCsv();
                break;
            case "writereportscsv":
                reportsToCsv();
                break;
            default:
                break;
        } 
    }
    private void createTable(String statements ){
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            //e.printStackTrace();
        }
        try {
            statement.executeUpdate(statements);
        } catch (SQLException e) {
            //e.printStackTrace();
        }
    }
    private void connect(){

        String url = "jdbc:sqlite:test.db";
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
       }
        try {
            con = DriverManager.getConnection(url);
            System.out.println("Bağlantı Başarılı...");
        } catch (SQLException ex) {
            flag=false;
            //System.out.println(ex.getSQLState());
        }
        if(flag) {
            createTable("CREATE TABLE IF NOT EXISTS `creditcard` (\n" +
                    "  `clientId` int(11) ,\n" +
                    "  `expiredDate` varchar(6) NOT NULL,\n" +
                    "  `cvcNumber` int(11) NOT NULL,\n" +
                    "  `balance` int(11) NOT NULL,\n" +
                    "  `cardnumber` varchar(20) NOT NULL\n" +
                    ")  ");

            createTable(
                    "CREATE TABLE IF NOT EXISTS `dealer` (\n" +
                            "  `name` varchar(100)  NOT NULL,\n" +
                            "  `surname` varchar(100)  NOT NULL,\n" +
                            "  `password` varchar(100)  NOT NULL,\n" +
                            "  `id` varchar(1000), \n" +
                            "  `income` int(11) NOT NULL  \n" +
                            ") ");
            createTable("CREATE TABLE IF NOT EXISTS `dof` (\n" +
                    "  `name` varchar(122)  ,\n" +
                    "  `surname` varchar(121)  ,\n" +
                    "  `id` varchar(1000)  ,\n" +
                    "  `income` int(11) NOT NULL,\n" +
                    "  `bornDay` varchar(15)  NOT NULL,\n" +
                    "  `creditPoint` int(11),\n" +
                    "  `email` varchar(100)  NOT NULL\n" +
                    ") ");
            createTable("\n" +
                    "INSERT INTO `dealer` (`name`, `surname`, `password`, `id`, `income`) VALUES\n" +
                    "('Dogukan', 'Gundogan', 'Dogi1604', '1', 3000);\n");
            createTable("\n" +
                    "INSERT INTO `dof` (`name`, `surname`, `id`, `income`, `bornDay`, `creditPoint`, `email`) VALUES\n" +
                    "('Dogukan Ali ', 'Gundogan', 1, 1000, '26:05:19', 1000, 'dogukangundogan5@gmail.com'),\n" +
                    "('Dogukan Ali ', 'Gundogan', 2, 2000, '0:26:5', 1000, 'dogukangundogan5@gmail.com'),\n" +
                    "('Dogukan Ali Gundogan', 'sdsfds', 3, 213, '1:1:2000', 1000, 'dogukangundogan5@gmail.com'),\n" +
                    "('Vildan', 'Gundogan', 4, 2000, '22:11:1973', 1000, 'vildan_gundogan@hotmail.com'),\n" +
                    "('Dogi', 'gundogan', 5, 34444, '1:1:2000', 1000, 'dufiudf@ffdd.mnn');");
        }
    }
    private void insertCard(){
        try {

            if (client!=null) {
                String request="SELECT * FROM dof WHERE name = ? and bornDay = ?";
                preparedStatement = con.prepareStatement(request);
                preparedStatement.setString(1, client.getName());
                preparedStatement.setString(2, client.getBornDate().toString());
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    request = "Insert Into creditcard (clientId,expiredDate,cvcNumber,balance,cardnumber) VALUES(" + "'" + id + "'," + "'" + card.getDate().toString2() + "'," + "'" + card.getCvcNumber() + "'," + "'" + card.getBalance() + "'," + "'" + card.getCardNumber() + "')";
                    statement.executeUpdate(request);
                }
            }
            else{
                String request = "Insert Into creditcard (clientId,expiredDate,cvcNumber,balance,cardnumber) VALUES(" + "'" + UUID.randomUUID().hashCode()+ "'," + "'" + card.getDate().toString2()+ "'," + "'" + card.getCvcNumber() + "'," + "'" +card.getBalance()+ "'," + "'" +card.getCardNumber()+ "')";
                statement.executeUpdate(request);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void insertUser(){
        try {
            statement = (Statement) con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, ex);
        };
        // Insert Into calisanlar (ad,soyad,email) VALUES('Yusuf','Çetinkaya','mucahit@gmail.com')
        String request = "Insert Into dof (name,surname,id,income,bornDay,creditPoint,email) VALUES(" + "'" + client.getName()+ "'," + "'" + client.getSurname() + "'," + "'" + UUID.randomUUID().toString()+"'," +"'"+ client.getIncome() + "'," + "'" +client.getBornDate().toString()+ "'," + "'"+client.getCreditPoint()+ "'," + "'"+client.getEmail()+ "')";
        client=new Client(client.getName(),client.getSurname(),client.getBornDate(),null,client.getCreditPoint(),client.getIncome(),client.getEmail());
        try {
            statement.executeUpdate(request);
        } catch (SQLException ex) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void insertDealer(){
        try {
            statement = (Statement) con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, ex);
        }; 
        String request = "Insert Into dealer (name,surname,password,id,income) VALUES(" + "'" + dealerParam.getName()+ "'," + "'" + dealerParam.getSurname() + "'," + "'" + dealerParam.getPassword()+ "',"+"'"+UUID.randomUUID().toString()+"',"+dealerParam.getIncome()+")";
        try {
            statement.executeUpdate(request);
        } catch (SQLException ex) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, ex);
        } 
        selectDealer();
    }
    private void delete(){ //suan icin kullanilmayacagi icin ici doldurulmadi
    }
    private void getDealersFromDatabase(){
        
        try{
            statement = (Statement) con.createStatement(); 
            preparedStatement=con.prepareStatement("select * from dealer");
            rs=preparedStatement.executeQuery();
            while(rs.next())
            {
                Dealer dealer_=new Dealer(rs.getString("name"),rs.getString("surname"),null,null,0,rs.getInt("income"),rs.getInt("id"));
                dealers.add(dealer_);
            }

        }
        catch(Exception e)
        {
            System.out.println("Error in getData"+e);
        }
    }
      private void reportsToCsv() { 
        File file=new File("ServiceReports.csv");
        FileWriter csvWriter=null;
        try {
            csvWriter = new FileWriter("ServiceReports.csv",true);
        } catch (IOException ex) {
            Logger.getLogger(userInterface.user.Credit.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!file.exists()){ 
            try {
                csvWriter.append("CarName");
                csvWriter.append(",");
                csvWriter.append("ClientName");
                csvWriter.append(",");
                csvWriter.append("CarProblem");
                csvWriter.append("\n");
                
            } catch (IOException ex) {
                Logger.getLogger(userInterface.user.Credit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                csvWriter.append(report.getClientName());
                csvWriter.append(",");
                csvWriter.append(report.getCarName());
                csvWriter.append(",");
                csvWriter.append(report.getReport());
                csvWriter.append("\n");
            } catch (IOException ex) {
                Logger.getLogger(userInterface.user.Credit.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            try {
                csvWriter.flush();
                csvWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(userInterface.user.Credit.class.getName()).log(Level.SEVERE, null, ex);
            }
            UserMenu userMenu=new UserMenu();
            oldFrame.setVisible(false);
            userMenu.setVisible(true);
        }
    }
    private void carsToCsv() {
        File file=new File("Cars.csv");
        FileWriter csvWriter=null;
        try {
            csvWriter = new FileWriter("Cars.csv",true);
        } catch (IOException ex) {
            Logger.getLogger(Credit.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!file.exists()){ 
            try {
                csvWriter.append("Name");
                csvWriter.append(",");
                csvWriter.append("Mail");
                csvWriter.append(",");
                csvWriter.append("CarName");
                csvWriter.append("\n");
                
            } catch (IOException ex) {
                Logger.getLogger(Credit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                csvWriter.append(client.getName());
                csvWriter.append(",");
                csvWriter.append(client.getEmail());
                csvWriter.append(",");
                csvWriter.append(vehicle.getTechnicalInformation().getNameOfCar());
                csvWriter.append("\n");
            } catch (IOException ex) {
                Logger.getLogger(Credit.class.getName()).log(Level.SEVERE, null, ex);
            }
       
            try {
                csvWriter.flush();
                csvWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Credit.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             
        }
    }
    private void dealerUpdate(){
        String request = "UPDATE dealer set income = ? where id = ?"; 
        try {
            statement = (Statement) con.createStatement(); 
            preparedStatement = con.prepareStatement(request);
            preparedStatement.setInt(1, dealerParam.getIncome());
            preparedStatement.setInt(2,dealerParam.getId() );
            preparedStatement.executeUpdate(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlFrontController.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
    }
    private void selectDealer(){
         try {
                statement = (Statement) con.createStatement(); 
                String request="SELECT * FROM dealer WHERE name = ? and password = ?";
                preparedStatement = con.prepareStatement(request);
                preparedStatement.setString(1,dealerParam.getName());
                preparedStatement.setString(2,dealerParam.getPassword());
                ResultSet rs=preparedStatement.executeQuery(); 
                if(rs.next()){
                    DealerCarResult dResult=new DealerCarResult();
                    Dealer dealer=new Dealer(rs.getString("name"), rs.getString("surname"), null, null, 0, rs.getInt("income"),rs.getInt("id"));
                    dResult.setDealer(dealer);
                    dResult.setVisible(true);
                    if (oldFrame!=null)
                        oldFrame.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(oldFrame,"User not found");
                }
                
            } catch (SQLException ex) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private void select(){
         try {
                oldFrame.setVisible(false);
                statement = (Statement) con.createStatement(); 
                String request="SELECT * FROM dof WHERE name = ? and bornDay = ?";
                preparedStatement = con.prepareStatement(request);
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,bornDay);
                ResultSet rs=preparedStatement.executeQuery(); 
                if(rs.next()){
                    request="SELECT * FROM creditcard WHERE clientId = ?";
                    preparedStatement = con.prepareStatement(request);
                    preparedStatement.setInt(1,rs.getInt("id"));
                    ResultSet rs1=preparedStatement.executeQuery();
                    if(rs1.next())
                        client=new Client(rs.getString("name"),rs.getString("surname"),new Date(rs.getString("bornDay")),new CreditCard(rs.getString("cardnumber"),rs.getString("name"), rs1.getString("expiredDate"),rs1.getInt("cvcNumber"),rs1.getInt("balance")),rs.getInt("creditPoint"),rs.getInt("income"),rs.getString("email"));
                    else
                        client=new Client(rs.getString("name"),rs.getString("surname"),new Date(rs.getString("bornDay")),null,rs.getInt("creditPoint"),rs.getInt("income"),rs.getString("email"));
                    UserMenu userMenu=new UserMenu();
                    userMenu.setVisible(true);
                }else{
                   
                    UserInformation userInformation=new UserInformation();
                    userInformation.setVisible(true);
                }
                
            } catch (SQLException ex) {
            Logger.getLogger(UserInformation.class.getName()).log(Level.SEVERE, null, ex);
            }
    } 
    private String getHash(String password){
        MessageDigest md = null;  
        try {
                md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] messageDigest = md.digest(password.getBytes());   
        BigInteger no = new BigInteger(1, messageDigest);   
        String hashtext = no.toString(16);  
        while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
        }
        return hashtext;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }



    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public SqlFrontController getSfc() {
        return sfc;
    }

    public void setSfc(SqlFrontController sfc) {
        this.sfc = sfc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public String getBornDay() {
        return bornDay;
    }

    public void setBornDay(String bornDay) {
        this.bornDay = bornDay;
    }
 
    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
 

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public ArrayList<Car> getResult() {
        return result;
    }

    public void setResult(ArrayList<Car> result) {
        this.result = result;
    }

    public DealerParam getDealerParam() {
        return dealerParam;
    }

    public void setDealerParam(DealerParam dealerParam) {
        this.dealerParam = dealerParam;
    }

    public ArrayList<DealerParam> getResults() {
        return results;
    }

    public void setResults(ArrayList<DealerParam> results) {
        this.results = results;
    }

    @Override
    public JFrame getOldFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOldFrame(JFrame oldFrame) {
        this.oldFrame=oldFrame;
    }

    public ArrayList<Dealer> getDealers() {
        command("getdealers");
        return dealers;
    }

    public void setDealers(ArrayList<Dealer> dealers) {
        this.dealers = dealers;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
    
    
    
} 