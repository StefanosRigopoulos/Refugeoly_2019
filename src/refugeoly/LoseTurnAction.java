package refugeoly;

public class LoseTurnAction extends Action{
    
    private final int amountOfTurns;
    
    public LoseTurnAction(int amountOfTurns){
        this.amountOfTurns = amountOfTurns;
    }
    
    public void LoseTurnAction(){
        System.out.println("You lost " + this.amountOfTurns + " rounds.");
        System.out.println("");
        actRefugee.round += this.amountOfTurns;
    }
    
    @Override
    public void Act(Refugee refugee){
        this.actRefugee = refugee;
    }
}
