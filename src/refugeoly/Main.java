package refugeoly;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int x;
        do{
            System.out.println("Welcome to Refugeoly!");
            System.out.println("");
            System.out.println("1. Start");
            System.out.println("2. Return");
            System.out.println("3. Info & Help");
            System.out.println("4. Exit");
            x = input.nextInt();
            switch(x){
                case 1:
                {
                    int numPlayers;
                    do{
                        System.out.println("Refugees range from 1 to 4.");
                        System.out.print("Please specify the number of Refugees: ");
                        numPlayers = input.nextInt();
                    }while(numPlayers > 4 || numPlayers < 0);
                    
                    Game game = new Game(numPlayers);
                    game.playGame(numPlayers);
                    break;
                }
                case 2:
                {
                    System.out.println("Returning to previous game...");
                    break;
                }
                case 3:
                {
                    System.out.println("Refuegeoly is:");
                    System.out.println("A monopoly style game made to give a taste to the players of");
                    System.out.println("how difficult is for the refugees to get to Europe and start");
                    System.out.println("their lives again from the begining.");
                    System.out.println("Your objective is to reach the end of the board but");
                    System.out.println("along the rway there are many challenges for you to face.");
                    System.out.println("If you spend all your money you have lost the game.");
                    System.out.println("If you manage to get first to the end of the board you win.");
                    System.out.println("");
                    System.out.println("This game is made from:");
                    System.out.println("Stefanos Rigopoulos");
                    System.out.println("AM: 2022201800171");
                    System.out.println("Nikos Gyftonikolos");
                    System.out.println("AM: 2022201800039");
                    System.out.println("");
                    break;
                }
                case 4:
                {
                    System.out.println("Stopping the game...");
                    break;
                }
                default:
                {
                    System.out.println("Please choose a valid option.");
                    System.out.println("");
                    break;
                }
            }
        }while((x > 4) || (x <= 0) || (x == 3)); 
    }
}