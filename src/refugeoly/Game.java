package refugeoly;

import java.util.Scanner;

public class Game {
    
    public Refugee[] Refugees;
    public Board board;
    
    public Game(int numPlayers){
        this.Refugees = new Refugee[numPlayers];
        for(int i = 0; i < numPlayers; i++){
            Scanner input = new Scanner(System.in);
            System.out.println("Give me the name of Refugee number " + (i + 1));
            this.Refugees[i] = new Refugee(input.nextLine(), 10000, 0, 0, 0);
        }
        
        board = new Board();
        
        GiverEntity NGOBank = new GiverEntity(10000);
        ReceiverEntity MafiaBank = new ReceiverEntity(0);
        
        board.addSquare("0,Country in conflict.");   //Nothing
        board.addSquare("1,Food for the journey. Pay $100.", new PayMoneyAction(MafiaBank, 100));   //-100$ -> Expenses  // **Wrong RE**
        board.addSquare("2,Car. You get a free lift. Roll dice.", new RollDiceAction());    //Extra Roll
        board.addSquare("3,Communication gear. Mobile phone and sim card. Pay $300 to the Mafia Bank.",new PayMoneyAction(MafiaBank, 100));   //-300$ -> Mafia
        board.addSquare("4,Army Control. You go back to war box (0).", new GoToAction(0));   //Back to 0
        board.addSquare("5,Border 1. Go back to war box (0).", new GoToAction(0));   //Back to 0
        board.addSquare("6,Mafia. Pay 1000$.", new PayMoneyAction(MafiaBank, 1000));   //-1000 -> Mafia
        board.addSquare("7,Live Vest. You have an extra life if you land in the sea (Box 10).");   //**** (Immune to 7)
        board.addSquare("8,GPS Location. Stay for a turn.", new LoseTurnAction(1));   //Lose a turn
        board.addSquare("9,Boat. Pay 3000$ to the Mafia Bank. Roll dice.", new PayMoneyAction(MafiaBank, 3000), new RollDiceAction());   //-3000 -> Mafia + Extra Roll
        board.addSquare("10,Dead at Sea. You are dead and out of the game.");   //**** (Dead if not been to 7)
        board.addSquare("11,You get sick. Stay one turn.", new LoseTurnAction(1));   //Lose a turn
        board.addSquare("12,You reach an EU coast. Roll dice.", new RollDiceAction());   //Extra Roll
        board.addSquare("13,Tent and sleeping bag. Pay 200$ to the Mafia Bank.", new PayMoneyAction(MafiaBank, 200));   //-200 -> Mafia
        board.addSquare("14,Border Police. Stay one turn.", new LoseTurnAction(1));   //Lose a turn
        board.addSquare("15,Border Control 2. Back to Border Control 1.", new GoToAction(5));   //Back to 5
        board.addSquare("16,Refugee Camp. Pay 500$ to the Mafia bank to leave and roll dice.", new PayMoneyAction(MafiaBank, 500), new RollDiceAction());   //-500 -> Mafia + Extra Roll
        board.addSquare("17,Train. Roll dice.", new RollDiceAction());   //Extra Roll
        board.addSquare("18,Red Cross Shelter. Jump to river crossing box (22).",new GoToAction(22));   //Forward to 22
        board.addSquare("19,Guard Dogs. Stay one turn.", new LoseTurnAction(1));   //Lose a turn
        board.addSquare("20,NGO Support. You receive 1000$ from NGO Bank.", new ReceiveMoneyAction(NGOBank, 1000));   //+1000 -> NGO
        board.addSquare("21,Theft. You lose 1500$. Place this money in the Players Expenses box.", new PayMoneyAction(MafiaBank, 1500));   //-1500 -> Expenses // **Wrong RE**
        RollDiceAction roll22 = new RollDiceAction();
        board.addSquare("22,River Crossing. Roll dice and go backwards by the number on the dice.", new GoToAction(22 - roll22.dice));   //Back to (rolling dice number)
        board.addSquare("23,NGO Lift. Jump to family reunion box (29).", new GoToAction(29));   //Forward to 29
        board.addSquare("24,Border Police. Stay one turn.", new LoseTurnAction(1));   //Lose a turn
        board.addSquare("25,Border Control 3. Back to border 2 (box 15).", new GoToAction(15));   //Back to 15
        board.addSquare("26,Asylum Paperwork. Pay 1000$ to Mafia Bank. Option A: Pay $1500 to Mafia Bank and roll dice. Option B: Don’t pay and stay 2 turns.");   //-1000 -> Mafia + ****
        board.addSquare("27,Storm. Stay one turn.", new LoseTurnAction(1));   //Lose a turn
        board.addSquare("28,UNHCR Aid. Roll dice.", new RollDiceAction());   //Extra Roll
        board.addSquare("29,Family Reunion. Jump to bus box (31).", new GoToAction(31));   //Forward to 31
        board.addSquare("30,Right Wing Militia. Back to Border police box (24).", new GoToAction(24));   //Back to 24
        board.addSquare("31,Mafia Bus. Pay 800$ to Mafia Bank. Roll dice.", new PayMoneyAction(MafiaBank, 800), new RollDiceAction());   //-800 -> Mafia + Extra Roll
        board.addSquare("32,Government Detention Camp. Stay one turn.", new LoseTurnAction(1));   //Lose a turn
        board.addSquare("33,Asylum Seeker Application rejected. Back to Train box (17) and Roll dice.", new GoToAction(17), new RollDiceAction());   //Back to 17 + Extra Roll
        board.addSquare("34,Border Police. Stay one turn.", new LoseTurnAction(1));   //Lose a turn
        board.addSquare("35,Border Control 4. Back to Border 3 (box 25).", new GoToAction(25));   //Back to 25
        board.addSquare("36,Asylum Seeker Application Approved. You win.", new WinAction());   //Win
        board.addSquare("37,Mafia. Pay 1000$ to Mafia Bank.", new PayMoneyAction(MafiaBank, 1000));   //-1000 -> Mafia
        board.addSquare("38,Deported. You are sent back to war box (0).", new GoToAction(0));   //Back to 0
        board.addSquare("39,New Home. You are finally accepted. You win.", new WinAction());   //Win
    }
    
    public void playGame(int numPlayers){
        
        int winner = -1, round = 0;
        do{
            System.out.println("");
            System.out.println("This is the " + round + " round of the game.");
            for (int i = 0; i < numPlayers; i++){
                if (round == Refugees[i].round){
                    System.out.println("");
                    System.out.println("-= Now playing: " + Refugees[i].getName() + " =-");
                    System.out.println("");
                    Scanner input = new Scanner(System.in);
                    String move = input.nextLine();
                    do{
                        switch(move){
                        case "Roll":
                            try {
                                RollDiceAction roundRoll = new RollDiceAction(Refugees[i]);
                                System.out.println("You rolled " + roundRoll.dice);
                                System.out.println(board.getSquare(Refugees[i].square));
                        
                                Square sq = board.getSquare(roundRoll.dice);
                                sq.Act(Refugees[i]);
                                System.out.println(Refugees[i].getMoney());
                            }
                            catch (ExceededNumberOfSquaresCheckedException error){
                                System.out.println(error.getMessage());
                                break;
                            }
                            break;
                        case "Save":
                            System.out.println("Saving current game...");
                            //SaveGame svg = new SaveGame();
                            //svg.saveGame(Refugees);
                            break;
                        default:
                            System.out.println("Please choose either to 'Roll' your dice or 'Save' the current game.");
                            break;
                        }
                        move = input.nextLine();
                    }while(!move.equals("Roll") || !move.equals("Save"));
                }
                else{
                    System.out.println("You don't play this round because last round you lost your turn.");
                }
                if (Refugees[i].doesWins()){
                    winner = i;
                    break;
                }
            }
            round++;
        }while(winner == -1);
        
        System.out.println("");
        System.out.println("--== Congratulations! ==--");
        System.out.println("");
        System.out.println("->   " + Refugees[winner].getName() + "   <-");
        System.out.println("");
        System.out.println("Thanks for playing Refugeoly!");
        System.out.println("");
        System.out.println("A monopoly based game made from:");
        System.out.println("Stefanos Rigopoulos");
        System.out.println("Nikos Gyftonikolos");
        System.out.println("");
    }
}