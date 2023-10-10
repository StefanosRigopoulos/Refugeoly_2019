package refugeoly;

public class Refugee implements MoneyGiver, MoneyReceiver{
    
    ReceiverEntity Expenses;
    public String name;
    private int money;
    public int square;
    public int round;
    public int win;
    public Board board;
    
    public Refugee(String name, int money, int square, int round, int win){
        this.name = name;
        this.money = money;
        this.square = square;
        this.round = round;
        this.win = win;
        Expenses = new ReceiverEntity(0);
    }
    
    @Override //Trash
    public void giveMoney(Refugee Receiver, int amount) throws NoMoneyCheckedException{
        if (amount < this.money){
            this.money = this.money - amount;
            Expenses.receiveMoney(amount);
            Receiver.receiveMoney(amount);
        }
        else{
            //Make him lose!
            throw new NoMoneyCheckedException("Not enough money for this transaction.");
        }
    }
    
    @Override
    public void giveMoney(ReceiverEntity RE, int amount) throws NoMoneyCheckedException{
        if (amount < this.money){
            this.money = this.money - amount;
            RE.receiveMoney(amount);
        }
        else{
            //Make him lose!
            throw new NoMoneyCheckedException("Not enough money for this transaction.");
        }
    }
    
    @Override
    public void receiveMoney(int money){
        this.money = this.money + money;
    }
    
    public void moveTo(int newSquare){
        this.square = newSquare;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getSquare(){
        return this.square;
    }
    
    public int getMoney(){
        return this.money;
    }
    
    public int getExpenses(){
        return Expenses.getMoney();
    }
    
    public int getRounds(){
        return this.round;
    }
    
    public boolean doesWins(){
        if (win == 1){
            return true;
        }
        else{
            return false;
        }
    }
}