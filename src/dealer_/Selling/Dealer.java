package dealer_.Selling;

import interfaces.Person;
import vehicle.Car;

import java.util.ArrayList;
import person.CreditCard;
import person.Date;
    

public class Dealer extends Person {
    private boolean busy; 
    private int id;
    public Dealer(String name, String surname, Date bornDate, CreditCard creditCard, int creditPoint, int income,int id) {
        super(name, surname, bornDate, creditCard, creditPoint, income,"");
        this.id=id;
    }

    public ArrayList<Car> searhCar(String model,int gearType, double volumeOfEngine, int maxPrice, int minPrice, int year, ArrayList<Car> cars){
        willMount();
        ArrayList<Car>result=new ArrayList<>();
        for (Car car:cars){
            if(car.equals(gearType,volumeOfEngine,minPrice,maxPrice,year,model))
                result.add(car);
        }
        didMount();
        return result;
    }
 
    @Override
    public void willMount() {
        busy=true;
    }
    @Override
    public void didMount() {
        busy=false;
    }
    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }


    @Override
    public void useEffect() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
