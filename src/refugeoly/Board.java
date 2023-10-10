package refugeoly;

import java.util.ArrayList;

public class Board {
    
    public ArrayList<Square> squares;
    public int numberBoard = -1;
    
    public Board(){
        this.squares = new ArrayList<Square>();
    }
    
    public void addSquare(String square){
        Square sq = new Square(square);
        squares.add(sq);
        numberBoard++;
    }
    
    public void addSquare(String square, Action action){
        Square sq = new Square(square, action);
        squares.add(sq);
        numberBoard++;
    }
    
    public void addSquare(String square, Action action1, Action action2){
        Square sq = new Square(square, action1, action2);
        squares.add(sq);
        numberBoard++;
    }
    
    public Square getSquare(int square){
        return squares.get(square);
    }
}