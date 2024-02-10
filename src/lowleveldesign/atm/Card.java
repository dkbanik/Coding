package lowleveldesign.atm;

public class Card {
    private String cardNumber;
    private int pin;
    private User user;

    public Card(String cardNumber, int pin, User user) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.user = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public User getUser() {
        return user;
    }
}
