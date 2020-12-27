package dealer_.Selling;

import person.bank.Bank;
import person.Client;
import vehicle.Car;
import vehicle.factorydesign.Store;
import dealer_.Selling.*;
import interfaces.Vehicle;
import person.bank.Credit;

import java.util.ArrayList;
import userInterface.SqlFrontController;
import vehicle.Motorcycle;


public class CarGallery {
    /**
     * <div>
     *     <h1>Car Gallery</h1>
     *     <div>
     *         <p>Car Gallery is a place in which list of car and
     *         dealer are held, and the dealer practises car selling
     *         The Bank, however, only practises giving loan for now.</p>
     *     </div>
     * </div>
     */
    private ArrayList<Bank>banks=new ArrayList<>();
    private Client client;
    private static CarGallery carGallery;
    private dealer_.Selling.Dealer dealer_;
    private ArrayList<dealer_.Selling.Dealer> dealers=new ArrayList<>();
    private ArrayList<Car> cars;
    private ArrayList<Motorcycle> motorcycles;
    public CarGallery getCarGallery() {
        if(carGallery==null) {
            carGallery = new CarGallery();
            Store carStore=new Store();
            carGallery.dealers=new SqlFrontController().getSqlFrontController().getDealers();
            carGallery.cars=carStore.requestCar();
            carGallery.banks=carStore.requestBank(5);
            carGallery.motorcycles=carStore.requestMotorcycle();
        }
        return carGallery;
    }

    public ArrayList<Credit> searchCredit(int month,int amount){
        ArrayList<Credit>result=new ArrayList<>();
        for(Bank bank:banks){
            bank.creditCalculate(month,amount);
            result.add(bank.creditCalculate(month,amount));
        }
        return result;
    }
    public ArrayList<Car> search(String model,int gearType,double volumeOfEngine,int maxPrice,int minPrice,int year,Client client){
        //paremetre al ve onu dealer icinde search methoduna ver
        this.client=client;
        for(dealer_.Selling.Dealer dealer:dealers){
            if(!dealer.isBusy())
                dealer_=dealer;
        } 
        return dealer_.searhCar(model,gearType,volumeOfEngine,maxPrice,minPrice,year,this.cars);
    }
    public void remove(Vehicle vehicle){
        if(vehicle instanceof Car){
            carGallery.cars.remove(vehicle);
        }else if(vehicle instanceof Motorcycle){
            carGallery.motorcycles.remove(vehicle);
        }
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }

    public void setBanks(ArrayList<Bank> banks) {
        this.banks = banks;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Motorcycle> getMotorcycles() {
        return motorcycles;
    }

    public void setMotorcycles(ArrayList<Motorcycle> motorcycles) {
        this.motorcycles = motorcycles;
    }

    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCarGallery(CarGallery carGallery) {
        this.carGallery = carGallery;
    }

    public dealer_.Selling.Dealer getDealer_() {
        return dealer_;
    }

    public void setDealer_(dealer_.Selling.Dealer dealer_) {
        this.dealer_ = dealer_;
    }

    public ArrayList<dealer_.Selling.Dealer> getDealers() {
        return dealers;
    }

    public void setDealers(ArrayList<dealer_.Selling.Dealer> dealers) {
        this.dealers = dealers;
    }
 
}
