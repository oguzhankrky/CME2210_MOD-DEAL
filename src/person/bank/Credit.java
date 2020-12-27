package person.bank;



import person.bank.Bank;
import person.Client;
import person.bank.Bank;

public class Credit {

    private Bank bank;
    private Client person;
    private int amount;
    private int month;
    private double interestRate;
    private double newAmount;
    public Credit(Bank bank, Client person, int month,int amount,double interestRate) {
        this.bank = bank;
        this.person = person;
        this.month = month;
        this.amount=amount;
        this.interestRate=interestRate;
    }

    public Credit() {
    }

    public void calculateRate(){
        newAmount=amount+ (interestRate*amount*month/3600);
    }
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Client getPerson() {
        return person;
    }

    public void setPerson(Client person) {
        this.person = person;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getNewAmount() {
        return newAmount;
    }

    public void setNewAmount(double newAmount) {
        this.newAmount = newAmount;
    }
}
