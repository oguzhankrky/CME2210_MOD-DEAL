package person;


public class CreditCard {

    
    
    private String cardNumber;
    private Date date;
    private String cardHolderName;
    private int cvcNumber;
    private int balance;

    public CreditCard(String cardNumber, String date, String cardHolderName, int cvcNumber, int balance) {
        this.cardNumber = cardNumber;
        this.date = new Date(date);
        this.cardHolderName = cardHolderName;
        this.cvcNumber = cvcNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  cardNumber +
                ":" + date +
                ":'" + cardHolderName +
                ":" + cvcNumber +
                ":" + balance;
    }
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public int getCvcNumber() {
        return cvcNumber;
    }

    public void setCvcNumber(int cvcNumber) {
        this.cvcNumber = cvcNumber;
    }
}
