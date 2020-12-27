package com.example.cardeal;
// Necessary  car technical features created
class CarStore {
    private String Make;
    private  String Model;
    private  String Year;
    private String Engine_Fuel_Type;
    private String Engine_HP;
    private String Engine_Cylinders;
    private String Transmission_Type;
    private String Driven_Wheels;
    private String Number_of_Doors;
    private String Market_Category;
    private String Vehicle_Size;
    private String Vehicle_Style;
    private String city_mpg;
    private String Popularity;
    private String MSRP;

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getEngine_Fuel_Type() {
        return Engine_Fuel_Type;
    }

    public void setEngine_Fuel_Type(String engine_Fuel_Type) {
        Engine_Fuel_Type = engine_Fuel_Type;
    }

    public String getEngine_HP() {
        return Engine_HP;
    }

    public void setEngine_HP(String engine_HP) {
        Engine_HP = engine_HP;
    }

    public String getEngine_Cylinders() {
        return Engine_Cylinders;
    }

    public void setEngine_Cylinders(String engine_Cylinders) {
        Engine_Cylinders = engine_Cylinders;
    }

    public String getTransmission_Type() {
        return Transmission_Type;
    }

    public void setTransmission_Type(String transmission_Type) {
        Transmission_Type = transmission_Type;
    }

    public String getDriven_Wheels() {
        return Driven_Wheels;
    }

    public void setDriven_Wheels(String driven_Wheels) {
        Driven_Wheels = driven_Wheels;
    }

    public String getNumber_of_Doors() {
        return Number_of_Doors;
    }

    public void setNumber_of_Doors(String number_of_Doors) {
        Number_of_Doors = number_of_Doors;
    }

    public String getMarket_Category() {
        return Market_Category;
    }

    public void setMarket_Category(String market_Category) {
        Market_Category = market_Category;
    }

    public String getVehicle_Size() {
        return Vehicle_Size;
    }

    public void setVehicle_Size(String vehicle_Size) {
        Vehicle_Size = vehicle_Size;
    }

    public String getVehicle_Style() {
        return Vehicle_Style;
    }

    public void setVehicle_Style(String vehicle_Style) {
        Vehicle_Style = vehicle_Style;
    }

    public String getCity_mpg() {
        return city_mpg;
    }

    public void setCity_mpg(String city_mpg) {
        this.city_mpg = city_mpg;
    }

    public String getPopularity() {
        return Popularity;
    }

    public void setPopularity(String popularity) {
        Popularity = popularity;
    }

    public String getMSRP() {
        return MSRP;
    }

    public void setMSRP(String MSRP) {
        this.MSRP = MSRP;
    }

    @Override
    public String toString() {
        return "-----------------------------\n" +
                "Make='" + Make + '\'' +
                "\n"+
                "Model='" + Model + '\'' +
                "\n"+
                "Year='" + Year + '\'' +
                "\n"+
                "Engine_Fuel_Type='" + Engine_Fuel_Type + '\'' +
                "\n"+
                "Engine_HP='" + Engine_HP + '\'' +
                "\n"+
                "Engine_Cylinders='" + Engine_Cylinders + '\'' +
                "\n"+
                "Transmission_Type='" + Transmission_Type + '\'' +
                "\n"+
                "Driven_Wheels='" + Driven_Wheels + '\'' +
                "\n"+
                "Number_of_Doors='" + Number_of_Doors + '\'' +
                "\n"+
                "Market_Category='" + Market_Category + '\'' +
                "\n"+
                "Vehicle_Size='" + Vehicle_Size + '\'' +
                "\n"+
                "Vehicle_Style='" + Vehicle_Style + '\'' +
                "\n"+
                "city_mpg='" + city_mpg + '\'' +
                "\n"+
                "Popularity='" + Popularity + '\'' +
                "\n"+
                "MSRP='" + MSRP + '\'' +
                "\n"+
                "-----------------------------\n" +
                ' ';
    }
}
