package vehicle.vehicleIdentities;

public class Fuel {
    private double highwayMPG;
    private double cityMPG;
    /**
     * 
     * @param highwayMPG fuel type
     * @param cityMPG fuel type
     */
    public Fuel(double highwayMPG, double cityMPG) {
        this.highwayMPG = highwayMPG;
        this.cityMPG = cityMPG;
    }

    @Override
    public String toString() {
        return "Fuel" +"\n"+
                "highwayMPG=" + highwayMPG +"\n"+
                "cityMPG=" + cityMPG +"\n"; 
    }

    public double getHighwayMPG() {
        return highwayMPG;
    }

    public void setHighwayMPG(double highwayMPG) {
        this.highwayMPG = highwayMPG;
    }

    public double getCityMPG() {
        return cityMPG;
    }

    public void setCityMPG(double cityMPG) {
        this.cityMPG = cityMPG;
    }
}
