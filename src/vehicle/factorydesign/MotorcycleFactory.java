/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle.factorydesign;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import vehicle.Car;
import vehicle.Motorcycle;
import vehicle.vehicleIdentities.Feature;
import vehicle.vehicleIdentities.Fuel;
import vehicle.vehicleIdentities.Technic;


public class MotorcycleFactory {
    /**
     * <div>
     *     <h1>MotorcycleFactory</h1>
     *     <div>
     *         <p>Factory class is part of the design pattern,
     *         and according to direction,which comes from store class.
     *         Factory class puts required objects out</p>
     *     </div>
     * </div>
     */
    public final String DATABASE_NAME="MotorcycleData.csv";
    private ArrayList<Motorcycle> motorcycles=new ArrayList<>();
    
    private void createDatabase() {
        try{
            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader(DATABASE_NAME));
            int counter=0;
            while ((row = csvReader.readLine()) != null) {
                if(counter!=0) {
                    String[] data = row.split(",");
                    int gear = 1;
                    String money=data[3].substring(data[3].indexOf("$")+1)+"000";
                    String mileage=data[9].substring(data[9].indexOf("\"")+1)+"000";
                    vehicle.vehicleIdentities.Engine engine = new vehicle.vehicleIdentities.Engine(0,0,null);
                    Technic technic = new Technic(data[12], data[14], Integer.parseInt(data[8]),Double.parseDouble(money), gear,"","","");
                    Motorcycle motorcycle = new Motorcycle(engine, technic,null);
                    motorcycle.setMileage(mileage);
                    motorcycles.add(motorcycle);

                }else counter++;
            }
            csvReader.close();

        }catch (Exception e){
            System.err.println(e);
        }
    }
    public ArrayList<Motorcycle> create() {
        createDatabase();
        return motorcycles;
    }
}
