package person;

import dealer_.Selling.CarGallery;
import dealer_.Service.ServiceEmployee;
import interfaces.Person;
import interfaces.Vehicle;
import person.bank.Credit;
import vehicle.Car;



import java.util.ArrayList;
import javax.swing.JFrame;
import userInterface.service.ServiceCarSelect;
import userInterface.service.ServiceReport;

public class Client extends Person {

    public ArrayList<Credit> credits=new ArrayList<>();

    public Client(String name, String surname, Date bornDate, CreditCard creditCard, int creditPoint, int income,String email) {
        super(name, surname, bornDate, creditCard, creditPoint, income,email);
    }
    public void choosenCar(Vehicle vehicle,Credit credit){
        if (credit!=null){
            setIncome(getIncome()-credit.getAmount()/credit.getMonth());
            credits.add(credit);
            buyCar(vehicle);
            CarGallery carGallery=new CarGallery().getCarGallery();
            carGallery.remove(vehicle); 
        }
    }
    public boolean creditRequest(Credit credit){
         return credit.getBank().requestCredit(credit);
    }
    public ArrayList<Car> searchCar(String model,int gearType, double volumeOfEngine, int maxPrice, int minPrice, int year){
        CarGallery carGallery= new CarGallery().getCarGallery();
        ArrayList<Car>result=carGallery.search(model,gearType,volumeOfEngine,maxPrice,minPrice,year,this);
        return result;
    }
    public boolean getService(JFrame jframe){
        ServiceReport sr=new ServiceReport();
        Car car=null;
        if(this.getVehicles().size()>-1){
            ServiceCarSelect scs=new ServiceCarSelect(sr, true,this);
            jframe.setVisible(false);
            scs.setEmail(this.getEmail());
            scs.setOldFrame(jframe);
            scs.setVisible(true);
            sr.setVisible(true);
            sr.setOldFrame(jframe);
            sr.getCarModel().setText(scs.carText);
            sr.getClientText().setText(scs.clientText);
            return false;
        } 
        return true;
    }

    @Override
    public void didMount() {

    }

    @Override
    public void willMount() {

    }

    @Override
    public void useEffect() {

    }
}
