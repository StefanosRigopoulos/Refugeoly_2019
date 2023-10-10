package refugeoly;

public class ReceiverEntity implements MoneyReceiver{
    
    private int money;
    
    public ReceiverEntity(int amount){
        this.money = amount;
    }
    
    public int getMoney(){
        return this.money;
    }
    
    @Override
    public void receiveMoney(int amount){
        this.money = this.money + amount;
    }
}