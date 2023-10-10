package refugeoly;

public class GiverEntity implements MoneyGiver{
    
    private int money;
    
    public GiverEntity(int amount){
        this.money = amount;
    }
    
    public int getMoney(){
        return this.money;
    }
    
    @Override
    public void giveMoney(Refugee Receiver, int amount) throws NoMoneyCheckedException{
        if (amount <= this.money){
            this.money = this.money - amount;
            Receiver.receiveMoney(amount);
        }
        else{
            throw new NoMoneyCheckedException("NGO Bank is out of Money.");
        }
    }
    
    @Override //Trash
    public void giveMoney(ReceiverEntity RE, int amount) throws NoMoneyCheckedException{
        if (amount <= this.money){
            this.money = this.money - amount;
            RE.receiveMoney(amount);
        }
        else{
            throw new NoMoneyCheckedException("NGO Bank is out of Money.");
        }
    }
}