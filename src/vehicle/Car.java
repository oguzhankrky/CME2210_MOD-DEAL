package vehicle;

import interfaces.Person;
import interfaces.Vehicle;
import vehicle.vehicleIdentities.Engine;
import vehicle.vehicleIdentities.Technic;

import java.util.Random;

public class Car extends Vehicle {

    public Car() {
    }

    public Car(Engine engine, Technic technicalInformation, Person owner) {
        super(engine, technicalInformation,owner);
    }

    @Override
    public String toString() {
        return "Car: "+"\n"+this.getTechnicalInformation().toString()+"\n---------\n"+this.getEngine().toString()+"\n---------\n"+testToString();
    }

    public boolean equals(int gearType, double volumeOfEngine, int maxPrice, int minPrice, int year,String model) {
        return (this.getEngine().getVolume() >= volumeOfEngine && this.getTechnicalInformation().equals(year, gearType, minPrice, maxPrice, model));

    }
    public String testToString(){
        int [] arr=test();
        String str=""; 
        str+="Engine Performance :"+arr[0];
        str+="\nBrake Performance :"+arr[1];
        str+="\nSoftware Test :"+arr[2];
        return str;
        
    }
    public int[] test(){
        int[] test={new Random().nextInt(100),new Random().nextInt(100),new Random().nextInt(100)};
        return test;
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
