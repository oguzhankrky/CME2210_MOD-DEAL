/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealer_.Service.FactoryDesign;

import dealer_.Service.ServiceEmployee;
import java.util.ArrayList;

public class ServiceEmployeeStore {
    /**
     * <div>
     * <h1> ServiceEmployeeStore Design</h1>
     * <div>
     * <p>Various design patterns were used in this project
     * to build up. In this package, factory design was used to create
     * the objects of Service Employee. In design process
     * creating required object with regard to will is the duty of function of store class.
     * </div>
     * </div>
     */
    
    
    
    
    private int employeeNumber;
    private ArrayList<ServiceEmployee> employees=new ArrayList<>();
    public void createEmployee(){
        ServiceEmployeeFactory employeeFactory =new ServiceEmployeeFactory();
        for(int index=0;index<employeeNumber;index++){
            employees.add(employeeFactory.createEmployee());
        }
    }

    public ArrayList<ServiceEmployee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<ServiceEmployee> employees) {
        this.employees = employees;
    }
    
    
}
