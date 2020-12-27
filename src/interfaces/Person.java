package interfaces;
import person.CreditCard;
import person.Date;
import vehicle.Car;

import java.util.ArrayList;

public abstract class Person implements Hook {

    private String name;
    private String surname;
    private Date bornDate;
    private CreditCard creditCard;
    private String email;
    private int creditPoint;
    private int income;
    private ArrayList<Vehicle> vehicles=new ArrayList<>();
    public Person(String name, String surname, Date bornDate, CreditCard creditCard, int creditPoint, int income,String email) {
        this.name = name;
        this.surname = surname;
        this.bornDate = bornDate;
        this.creditCard = creditCard;
        this.creditPoint = creditPoint;
        this.income = income;
        this.email=email;
        ArrayList<Car>cars=new ArrayList<>();
    }
    public void buyCar(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public  Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public int getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
