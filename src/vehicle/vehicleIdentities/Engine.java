package vehicle.vehicleIdentities;

public class Engine {
    private int power;
    private double volume;
    private Fuel fuel;
    /**
     * 
     * @param power hp of car
     * @param volume engine volume
     * @param fuel fuel object show average MPG
     */
    public Engine(int power, double volume, Fuel fuel) {
        this.power = power;
        this.volume = volume;
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Engine" +"\n"+
                "power=" + power +"\n"+
                ", volume=" + volume +"\n"+
                ", fuel=" + fuel +"\n";
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
}
