package refugeoly;

import java.util.Random;

public class RollDiceAction extends Action{
    
    public int dice;
    
    public RollDiceAction(){
    }
    
    public void RollDiceAction(){
        
        Random Dice = new Random();
        this.dice = 1 + Dice.nextInt(6);
        actRefugee.moveTo(actRefugee.getSquare() + this.dice);
    }
    
    public RollDiceAction(Refugee refugee) throws ExceededNumberOfSquaresCheckedException{
        
        Random Dice = new Random();
        this.dice = 1 + Dice.nextInt(6);
        
        if (refugee.getSquare() + this.dice < 40 && refugee.getSquare() + this.dice > 0){
            refugee.moveTo(refugee.getSquare() + this.dice);
        }
        else{
            throw new ExceededNumberOfSquaresCheckedException("You passed the win point and you have been returned to your square.");
        }
    }
    
    @Override
    public void Act(Refugee refugee){
        this.actRefugee = refugee;
    }
}
