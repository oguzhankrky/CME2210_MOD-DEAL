package com.example.cardeal;
//  User object was created.
public class User {

    private String name;
    private String surname;
    private String plate;
    private String brand;
    private String phone;



    public User(String name, String surname, String plate, String brand, String phone) {
        this.name = name;
        this.surname = surname;
        this.plate = plate;
        this.brand = brand;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPlate() {
        return plate;
    }

    public String getBrand() {
        return brand;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", plate='" + plate + '\'' +
                ", brand='" + brand + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
