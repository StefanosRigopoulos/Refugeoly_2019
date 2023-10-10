package refugeoly;

public class PayMoneyAction extends Action{
    
    private final ReceiverEntity RE;
    private final int amount;
    
    public PayMoneyAction(ReceiverEntity RE, int amount){
        this.RE = RE;
        this.amount = amount;
    }
    
    public void PayMoneyAction(){
        try{
            System.out.println("You are paying " + this.amount + " to the " + this.RE);
            System.out.println("");
            actRefugee.giveMoney(this.RE, this.amount);
        }
        catch (NoMoneyCheckedException error){
            System.out.println(error.getMessage());
        }
    }
    
    @Override
    public void Act(Refugee refugee){
        this.actRefugee = refugee;
        try{
            System.out.println("You are paying " + this.amount + " to the " + this.RE);
            System.out.println("");
            actRefugee.giveMoney(this.RE, this.amount);
        }
        catch (NoMoneyCheckedException error){
            System.out.println(error.getMessage());
        }
    }
}
