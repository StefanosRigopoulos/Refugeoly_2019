package refugeoly;

public class ReceiveMoneyAction extends Action{
    
    private final GiverEntity GE;
    private final int amount;
    
    public ReceiveMoneyAction(GiverEntity GE, int amount){
        this.GE = GE;
        this.amount = amount;
    }
    
    public void ReceiveMoneyAction(){
        
        try{
            System.out.println("You received " + this.amount + " from " + this.GE);
            System.out.println("");
            this.GE.giveMoney(actRefugee, this.amount);
        }
        catch (NoMoneyCheckedException error) {
            error.getMessage();
        }
    }
    
    @Override
    public void Act(Refugee refugee){
        this.actRefugee = refugee;
    }
}
