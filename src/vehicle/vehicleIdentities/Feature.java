package vehicle.vehicleIdentities;

public class Feature {
    private String name;
    private int price;
/**
 * 
 * @param name Name of features
 * @param price price of that features
 */
    public Feature(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Feature:" +"\n"+
                "name='" + name+"\n"+
                "price=" + price +"\n"; 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
