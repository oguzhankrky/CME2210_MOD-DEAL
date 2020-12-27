/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dealer_.Service.FactoryDesign;

import dealer_.Service.ServiceEmployee;
import java.util.Random;

public class ServiceEmployeeFactory {
    /**
     * <div>
     *     <h1>BankFactory</h1>
     *     <div>
     *         <p>Factory class is part of the design pattern,
     *         and according to direction,which comes from store class.
     *         Factory class puts required objects out</p>
     *     </div>
     * </div>
     */
    
    
    
    
    Random random=new Random();
    private String []names={"Mustafa","Mahmut","Ali","Dogukan","Oguzhan","Mert","Arda","Burak","Caner"};
    private String [] surnames={"Ozkan","Erbil","Karakaya","Gundogan","Gultekin","Gurbuz","Turan","Yilmaz","Erkin"};
    public ServiceEmployee createEmployee(){
        return new ServiceEmployee(names[random.nextInt(9)], surnames[random.nextInt(9)],null,null,0, 0,"");
    }
    
}
