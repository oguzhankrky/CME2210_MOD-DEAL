package com.example.cardeal.ui.cars;
// Necessary  motor technical features created
public class MotorStore {
    private String id;
    private String Condition;
    private String Condition_Desc;
    private String Price;
    private String  Location;
    private String Model_Year;
    private String Mileage;
    private String Exterior_Color;
    private String Make;
    private String Warranty;
    private String Model;
    private String Sub_Model;
    private String Type;
    private String Buy_Now;
    @Override
    public String toString() {// for print motor  technical features
        return "-----------------------------\n" +

                "Condition='" + Condition + '\'' +
                "\n"+
                "Condition_Desc='" + Condition_Desc + '\'' +
                "\n"+
                "Price='" + Price + '\'' +
                "\n"+
                "Location='" + Location + '\'' +
                "\n"+
                "Model_Year='" + Model_Year + '\'' +
                "\n"+
                "Mileage='" + Mileage + '\'' +
                "\n"+
                "Exterior_Color='" + Exterior_Color + '\'' +
                "\n"+
                "Make='" + Make + '\'' +
                "\n"+
                "Warranty='" + Warranty + '\'' +
                "\n"+
                "Model='" + Model + '\'' +
                "\n"+
                "Sub_Model='" + Sub_Model + '\'' +
                "\n"+
                "Type='" + Type + '\'' +
                "\n"+
                "Buy_Now='" + Buy_Now + '\'' +
                "\n"+
                "-----------------------------\n" +
                '\n';
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getCondition_Desc() {
        return Condition_Desc;
    }

    public void setCondition_Desc(String condition_Desc) {
        Condition_Desc = condition_Desc;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getModel_Year() {
        return Model_Year;
    }

    public void setModel_Year(String model_Year) {
        Model_Year = model_Year;
    }

    public String getMileage() {
        return Mileage;
    }

    public void setMileage(String mileage) {
        Mileage = mileage;
    }

    public String getExterior_Color() {
        return Exterior_Color;
    }

    public void setExterior_Color(String exterior_Color) {
        Exterior_Color = exterior_Color;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getWarranty() {
        return Warranty;
    }

    public void setWarranty(String warranty) {
        Warranty = warranty;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getSub_Model() {
        return Sub_Model;
    }

    public void setSub_Model(String sub_Model) {
        Sub_Model = sub_Model;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getBuy_Now() {
        return Buy_Now;
    }

    public void setBuy_Now(String buy_Now) {
        Buy_Now = buy_Now;
    }
}
