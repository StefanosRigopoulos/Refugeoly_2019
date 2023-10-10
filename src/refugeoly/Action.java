package refugeoly;

public abstract class Action {
    
    public Refugee actRefugee;
    
    public Action(){
    }
    
    public abstract void Act(Refugee refugee);
}