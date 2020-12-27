package interfaces;

import Stack.DynamicStack;
import vehicle.vehicleIdentities.Engine;
import vehicle.vehicleIdentities.Feature;
import vehicle.vehicleIdentities.Technic;
 

public abstract class Vehicle extends Servicable implements Hook{


    DynamicStack features;
    Engine engine;
    Technic technicalInformation;
    Person owner;
    public Vehicle() {
    }

    public Vehicle(Engine engine, Technic technicalInformation,Person owner) {
        this.features = new DynamicStack();
        this.engine = engine;
        this.technicalInformation = technicalInformation;
        this.owner=owner;
    }

    public void addFeatures(Feature feature){features.push(feature);}
    public Person getOwner(){return owner;}
    public Engine getEngine(){return engine;}
    public void addTechnicalInformation(Technic technic){}
    public void addEngine(Engine engine){}
    public Technic getTechnicalInformation(){return technicalInformation;}
    public void setFeatures(DynamicStack features){this.features=features;}
}
