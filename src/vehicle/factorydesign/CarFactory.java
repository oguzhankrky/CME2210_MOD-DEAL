package vehicle.factorydesign;
import Stack.DynamicStack;
import vehicle.Car;
import vehicle.vehicleIdentities.Feature;
import vehicle.vehicleIdentities.Fuel;
import vehicle.vehicleIdentities.Technic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
public class CarFactory {

    /**
     * <div>
     *     <h1>CarFactory</h1>
     *     <div>
     *         <p>Factory class is part of the design pattern,
     *         and according to direction,which comes from store class.
     *         Factory class puts required objects out</p>
     *     </div>
     * </div>
     */
    private final Random random=new Random();
    private final String [] FEATURES={"Park Sensoru","Hiz Sabitleyici","360 Kamera","Servetonic","Serit Takip Sistemi"};
    private final int [] prices={1000,4000,5000,1500,2020};
    public final String DATABASE_NAME="data.csv";
    private ArrayList<Car> cars=new ArrayList<>();
    private DynamicStack features;
    private int createFeatures(int number){
        int total=0;
        features=new DynamicStack();
        for (int i=0;i<number;i++){
            Feature feature=new Feature(FEATURES[i],prices[i]);
            total+=prices[i];
            features.push(feature);
        } 
        return total;
    }
    private void createDatabase() {
        try{
            String row;
            BufferedReader csvReader = new BufferedReader(new FileReader(DATABASE_NAME));
            int counter=0;
            while ((row = csvReader.readLine()) != null) {
                if(counter!=0) {
                    String[] data = row.split(",");
                    int gear = 0;
                    if (data[6].equals("MANUAL"))
                        gear = 2;
                    else
                        gear = 1;
                    vehicle.vehicleIdentities.Engine engine = new vehicle.vehicleIdentities.Engine(Integer.parseInt(data[4]), Integer.parseInt(data[14]), new Fuel(Double.parseDouble(data[4]), Double.parseDouble(data[14])));
                    int total=createFeatures(random.nextInt(5));
                    Technic technic = new Technic(data[1], data[0], Integer.parseInt(data[2]), 1000.0+total, gear, data[7], data[10], data[11]);
                    Car car = new Car(engine, technic,null);
                    car.setFeatures(features);
                    cars.add(car);

                }else counter++;
            }
            csvReader.close(); 
        }catch (Exception e){
        }
    }
    public ArrayList<Car> create() {
        createDatabase();
        return cars;
    }
}
