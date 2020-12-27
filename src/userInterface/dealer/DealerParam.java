/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.dealer;

public class DealerParam {
    private String name;
    private String surname;
    private String password;
    private int  income;
    private int id;
    public DealerParam(String name, String surname, String password,int income,int id) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.income=income;
        this.id=id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIncome() {
        return income;
    }

    public void setId(int income) {
        this.income = income;
    }

    public int getId() {
        return id;
    }
    
}
