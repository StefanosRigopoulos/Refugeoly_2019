package refugeoly;

public class NoMoneyCheckedException extends Exception{
    
    public NoMoneyCheckedException(){
    }
    
    public NoMoneyCheckedException(String msg){
        super(msg);
    }
}
