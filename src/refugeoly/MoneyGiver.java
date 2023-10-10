package refugeoly;

public interface MoneyGiver {
    
    public void giveMoney(Refugee Receiver, int money) throws NoMoneyCheckedException;
    public void giveMoney(ReceiverEntity RE, int money) throws NoMoneyCheckedException;
    
}