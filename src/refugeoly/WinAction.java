package refugeoly;

public class WinAction extends Action{
    
    public WinAction(){
    }
    
    public void WinAction(){
        actRefugee.win = 1;
    }
    
    @Override
    public void Act(Refugee refugee){
        this.actRefugee = refugee;
    }
}
