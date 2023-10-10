package refugeoly;

public class GoToAction extends Action{
    
    private final int where;
    
    public GoToAction(int where){
        this.where = where;
    }
    
    public void GoToAction(){
        System.out.println("");
        System.out.println("Going to " + this.where);
        System.out.println("");
        actRefugee.moveTo(this.where);
    }
    
    @Override
    public void Act(Refugee refugee){
        this.actRefugee = refugee;
    }
}
