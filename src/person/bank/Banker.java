package person.bank;
import person.bank.*;
import person.Client;
import person.Date;
import person.CreditCard;
import interfaces.Person;



public class Banker extends Person {

    private person.bank.Bank bank;
    private String id;
    private boolean isBusy;

    public Banker(String name, String surname, Date bornDate, CreditCard creditCard, int creditPoint, int income,String  id) {
        super(name, surname, bornDate, creditCard, creditPoint, income,"");
        isBusy=false;
        this.id=id;
    }

    public String toCsv(){
        if(this.getCreditCard()!=null)
            return this.getName()+","+this.getSurname()+","+this.getBornDate().toString()+","+this.getCreditCard().toString()+","+this.getCreditPoint()+","+this.getIncome()+","+id+"\n";
        else
            return this.getName()+","+this.getSurname()+","+this.getBornDate().toString()+","+"null"+","+this.getCreditPoint()+","+this.getIncome()+","+id+"\n";
            

            
    }
    public boolean giveCredit(Credit credit){
        willMount();
        if(credit.getPerson().getIncome()>credit.getNewAmount()/credit.getMonth()) {
            didMount();
            return true;
        }
        didMount();
        return false;

    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    @Override
    public void didMount() {
        setBusy(false);
    }

    @Override
    public void willMount() {
        setBusy(true);
    }

    @Override
    public void useEffect() {

    }
}
