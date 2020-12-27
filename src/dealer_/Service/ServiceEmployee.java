/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealer_.Service;

import vehicle.Car;
import interfaces.Person;
import javax.swing.JFrame;
import person.CreditCard;
import person.Date;





public class ServiceEmployee extends Person{
    private Car serviceCar;
    private boolean busy;
    private boolean repaired;
    private String ownerMail;

    public ServiceEmployee(String name, String surname, Date bornDate, CreditCard creditCard, int creditPoint, int income,String email) {
        super(name, surname, bornDate, creditCard, creditPoint, income,email);
    }

    public Car getServiceCar() {
        return serviceCar;
    }
    public void deliverCar(JFrame frame){
        willMount();
        Service service=new Service().getService();
        service.deliverCar(frame);
        serviceCar=null;
        didMount();
    }
    public void setServiceCar(Car serviceCar) {
        willMount();
        this.serviceCar = serviceCar;
        didMount();
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public void didMount() {
        if (serviceCar!=null)
            busy=true;
    }

    @Override
    public void willMount() {
        if (serviceCar==null) {
            busy = false;
            repaired=true;
        }
    }

    @Override
    public void useEffect() {

    }

    public boolean isRepaired() {
        return repaired;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public void setOwnerMail(String ownerMail) {
        this.ownerMail = ownerMail;
    }
    
}
