package vehicle.factorydesign;

import vehicle.Car;
import person.bank.Bank;

import java.util.ArrayList;
import vehicle.Motorcycle;
public class Store {

    /**
     * <div>
     * <h1>Store</h1>
     * <div>
     * <p>Various design patterns were used in this project
     * to build up. In this package, factory design was used to create
     * the objects of bank, motorcycle and car. In design process
     * creating required object with regard to will is the duty of function of store class.
     * </div>
     * </div>
     */
    /**
     *
     * @return list of car
     */
    public ArrayList<Car> requestCar(){
        CarFactory carFactory=new CarFactory();
        return carFactory.create();
    }
    /**
     * 
     * @param amountOfBank limit of bank list
     * @return list of bank
     */
    public ArrayList<Bank> requestBank(int amountOfBank){
        BankFactory bankFactory=new BankFactory();
        return bankFactory.create(amountOfBank);
    }
    /**
     * 
     * @return list of motorcycle
     */
    public ArrayList<Motorcycle> requestMotorcycle(){
        MotorcycleFactory motorcycleFactory=new MotorcycleFactory();
        return motorcycleFactory.create();
    }

}
