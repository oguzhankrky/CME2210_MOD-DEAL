package person.bank;
 


import person.Client; 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import person.Date; 
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger; 
import person.CreditCard;
public class Bank {

    private ArrayList<Banker> bankers=new ArrayList<>();
    private person.bank.ATM atm;
    private String name;
    private double interestRate;

    public Bank(person.bank.ATM atm, String name, double interestRate) {
        BufferedReader reader = null; 
        int counter=0;
        try {
            reader = new BufferedReader(new FileReader("BankerDatabase.csv"));
            String line=null;
            while ((line=reader.readLine()) != null){
                    String [] lines=line.split(",");
//                    Banker banker =new Banker(lines[0],lines[1],new Date(lines[2]),new CreditCard(lines[3].split(":")[0],lines[3].split(":")[1],lines[3].split(":")[2],Integer.parseInt(lines[3].split(":")[4]),Integer.parseInt(lines[3].split(":")[5])),Integer.parseInt(lines[4]),Integer.parseInt(lines[5]),lines[6]);
//                    bankers.add(banker);
                    counter++;
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            createBanker();

        } catch (IOException ex) {
            createBanker();

        } 
            createBanker();
        this.atm = atm;
        this.name=name;
        this.interestRate = interestRate;
    }
    private void createBanker(){
        Date date=new Date(14,10,1972);
        Banker banker=new Banker("Mehmet","Guleroglu",date,null,1000,5500,UUID.randomUUID().toString());
        banker.setBank(this);
        bankers.add(banker);
        date=new Date(14,10,1972);
        banker=new Banker("Meryem","Hamitoglu",date,null,1000,5500,UUID.randomUUID().toString());
        banker.setBank(this);
        bankers.add(banker);
        date=new Date(14,10,1972);
        banker=new Banker("Arda","Ozkan",date,null,1000,5500,UUID.randomUUID().toString());
        banker.setBank(this);
        bankers.add(banker);
        date=new Date(14,10,1972);
        banker=new Banker("Ezgi","Uzerli",date,null,1000,5500,UUID.randomUUID().toString());
        banker.setBank(this);
        bankers.add(banker);
        date=new Date(24,06,1999);
        banker=new Banker("Elif","Gurbuz",date,null,1000,5500,UUID.randomUUID().toString());
        banker.setBank(this);
        bankers.add(banker);
        writeCsv();
    }
    public void writeCsv(){
        FileWriter csvWriter;
        try {
            csvWriter = new FileWriter("BankerDatabase.csv");
            csvWriter.append("Name");
            csvWriter.append(",");
            csvWriter.append("Surname");
            csvWriter.append(",");
            csvWriter.append("BornDate");
            csvWriter.append(",");
            csvWriter.append("CreditCard");
            csvWriter.append(",");
            csvWriter.append("CreditPoint");
            csvWriter.append(",");
            csvWriter.append("Income");
            csvWriter.append(",");
            csvWriter.append("Id");
            csvWriter.append(","); 
            csvWriter.append("Bank");
            csvWriter.append("\n");
            for(Banker banker:bankers){ 
                csvWriter.append(banker.toCsv());
                csvWriter.append("\n");
            }
            csvWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Credit creditCalculate(int month,int amount){
        Credit credit=new Credit();
        credit.setBank(this);
        credit.setAmount(amount);
        credit.setMonth(month);
        credit.setInterestRate(this.interestRate);
        credit.calculateRate();
        return credit;
    }
    public boolean requestCredit(Credit credit){
        for(Banker banker:bankers){
            if (!banker.isBusy()){
                banker.setBusy(true);
                banker.setBank(this);
                return banker.giveCredit(credit);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "bankers=" + bankers.toString() + ", atm=" + atm.toString() + ", name=" + name + ", interestRate=" + interestRate ;
    }
    
    
    public void goToAtm(Client client){
        atm.drawMoney(client);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public ArrayList<Banker> getBankers() {
        return bankers;
    }

    public void setBankers(ArrayList<Banker> bankers) {
        this.bankers = bankers;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
