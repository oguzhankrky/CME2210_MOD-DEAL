package dealer_.Service;

import vehicle.Car;
import dealer_.Service.FactoryDesign.ServiceEmployeeStore;

import java.util.ArrayList;
import java.util.Properties;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import person.CreditCard;
import person.Date;


public class Service {
    private ArrayList<ServiceEmployee> serviceEmployees=new ArrayList<>();
    private static Service service;
    public Service getService(){
        if(service==null){
            service=new Service();
            ServiceEmployeeStore employeeStore=new ServiceEmployeeStore();
            employeeStore.createEmployee();
            serviceEmployees=employeeStore.getEmployees();
        }
        return service;
    }
    public void takeCar(Car car,String report){
        for(ServiceEmployee employee: serviceEmployees){
            if(!employee.isBusy()){
                car.setService(true);
                car.setServiceResult(report);
                employee.setServiceCar(car);
            }
        }
    }
    public void deliverCar(JFrame frame){
           JOptionPane.showConfirmDialog(frame, "Your car is ready!!!!");
    }
    
}
