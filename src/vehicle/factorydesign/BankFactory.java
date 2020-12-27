package vehicle.factorydesign;

import person.bank.ATM;
import person.bank.Bank;

import java.util.ArrayList;
public class BankFactory {

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
    private String[] bankNames={"Garanti","Finansbank","Isbankasi","Ziraat","Denizbank"};
    /**
     * 
     * @param amountOfBank is used as limit of bank in the scenario
     * @return list of bank
     */
    public ArrayList<Bank> create(int amountOfBank){
        ArrayList<Bank>banks=new ArrayList<>();
        if (amountOfBank>5||amountOfBank<=0)
            amountOfBank=5;
        for (int index=0;index<amountOfBank;index++){
            Bank bank=new Bank(new ATM(10000),bankNames[index],Math.random());
            banks.add(bank);
        }
        return banks;
    }
}
