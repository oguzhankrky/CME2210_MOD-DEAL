package vehicle.vehicleIdentities;

import java.util.Objects;

public class Technic {

    private String nameOfCar;
    private String brand;
    private int modelYear;
    private double price;
    private int gear;
    private String drivenWheels;
    private String sizeOfVehicle;
    private String typeOfVehicle;
/**
 * 
 * @param nameOfCar
 * @param brand
 * @param modelYear
 * @param price
 * @param gear
 * @param drivenWheels
 * @param sizeOfVehicle
 * @param typeOfVehicle 
 */

    public Technic(String nameOfCar, String brand, int modelYear, double price, int gear, String drivenWheels, String sizeOfVehicle, String typeOfVehicle) {
        this.nameOfCar = nameOfCar;
        this.brand = brand;
        this.modelYear = modelYear;
        this.price = price;
        this.gear = gear;
        this.drivenWheels = drivenWheels;
        this.sizeOfVehicle = sizeOfVehicle;
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getGear() {
        if(gear==1)
            return "automatic";
        else
            return "manuel";
    }

    public String getDrivenWheels() {
        return drivenWheels;
    }

    public void setDrivenWheels(String drivenWheels) {
        this.drivenWheels = drivenWheels;
    }

    public String getSizeOfVehicle() {
        return sizeOfVehicle;
    }

    public void setSizeOfVehicle(String sizeOfVehicle) {
        this.sizeOfVehicle = sizeOfVehicle;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public boolean equals(int modelYear, int gear, int minPrice, int maxPrice,String model) {
        return modelYear <= this.modelYear &&
                this.price<maxPrice&&this.price>minPrice&&
                gear == this.gear&&this.getBrand().toLowerCase().equals(model.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfCar, brand, modelYear, price, gear);
    }

    @Override
    public String toString() {
        return "Technic{" +
                "nameOfCar='" + nameOfCar +"\n"+
                "brand='" + brand +"\n"+
                "modelYear=" + modelYear +"\n"+
                "price=" + price +"\n"+
                "gear=" + gear +"\n"+
                "drivenWheels='" + drivenWheels +"\n"+
                "sizeOfVehicle='" + sizeOfVehicle +"\n"+
                "typeOfVehicle='" + typeOfVehicle +"\n";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNameOfCar() {
        return nameOfCar;
    }

    public void setNameOfCar(String nameOfCar) {
        this.nameOfCar = nameOfCar;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
