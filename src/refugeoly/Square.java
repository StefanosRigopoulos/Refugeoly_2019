package refugeoly;

import java.util.ArrayList;

public class Square {
    
    public ArrayList<Action> actions;
    public final String text;
    public final int squareNumber;
    public Board board;
    
    
    public Square(String textGiven){
        String textArray[] = textGiven.split(",");
        this.squareNumber = Integer.parseInt(textArray[0]);
        this.text = textArray[1];
    }
    
    public Square(String textGiven, Action action){
        String textArray[] = textGiven.split(",");
        this.squareNumber = Integer.parseInt(textArray[0]);
        this.text = textArray[1];
        this.actions = new ArrayList<Action>();
        addAction(action);
    }
    
    public Square(String textGiven, Action action1, Action action2){
        String textArray[] = textGiven.split(",");
        this.squareNumber = Integer.parseInt(textArray[0]);
        this.text = textArray[1];
        this.actions = new ArrayList<Action>();
        addAction(action1);
        addAction(action2);
    }
    
    public void addAction(Action action){
        actions.add(action);
    }
    
    public void Act(Refugee refugee){
        
        Action[] acts = new Action[2];
        for (int i = 0; i < actions.size(); i++){
            acts[i] = actions.get(i);
            Action act = actions.get(i);
            act.Act(refugee);
        }
    }
    
    public int getNumber(){
        return squareNumber;
    }
    
    public String getText(){
        return text;
    }
    
    @Override
    public String toString(){
        return squareNumber + ". " + text;
    }
}