/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;
 
import interfaces.Person;
import interfaces.Vehicle;
import vehicle.vehicleIdentities.Engine;
import vehicle.vehicleIdentities.Technic;

public class Motorcycle extends Vehicle{ 

    public Motorcycle() {
    }
    private String mileage;
    public Motorcycle(Engine engine, Technic technicalInformation, Person owner) {
        super(engine, technicalInformation,owner);
    }

    @Override
    public String toString() {
        return "Motorcycle{" + this.getTechnicalInformation().toString()+this.getEngine().toString()+'}';
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
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
