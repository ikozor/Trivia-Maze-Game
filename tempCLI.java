import java.io.File;
import java.util.Scanner;

/*
    PLEASE forgive for what you see, I put this together really quickly just to test my program

    I apologize again
 */
public class tempCLI {
    static Scanner myScanner = new Scanner(System.in);

    public tempCLI(){
        startGame();
        while(Player.getPlayer().getPlayerPosition() != Math.pow(Player.getPlayer().getLevel().getValue()+3, 2)-1){
            System.out.println("Move in direction, UP/DOWN/LEFT/RIGHT or Select MENU: ");
            String selection = myScanner.next();
            if(selection.equals("MENU")){
                System.out.println("QUIT - Quit Game\nSAVE - Save Game");
                String menuSelection = myScanner.next();
                if(menuSelection.equals("SAVE"))
                    GameState.saveGame();
                else{
                    GameState.endGame();
                    startGame();
                }
            }
            else{
                Player.getPlayer().movePlayer(Directions.valueOf(selection), true);
                System.out.println(Player.getPlayer().getPlayerPosition());
                if(Player.getPlayer().isMyGameLost()) {
                    System.out.println("LOST GAME");
                    System.exit(0);
                }
            }
        }
    }

    private void startGame(){
        System.out.println("Select:\nNEW - New Game\nLOAD - Load Game");
        String selection = myScanner.next();
        if(selection.equals("LOAD")){
            File temp = new File("save_files\\savedGame");
            if(temp.exists())
                GameState.loadGame();
            else{
                System.out.println("NO LOAD DATA");
                createGame();
            }
        }
        else
            createGame();
    }
    private void createGame(){
        System.out.print("Name: ");
        String name = myScanner.next();
        System.out.print("Level 1-3: ");
        int level = myScanner.nextInt();
        System.out.println();
        GameState.newGame(name,Difficulty.Hard);
    }



    public static boolean askQuestion(){
        //pull random question and ask question
        System.out.println("Answer correct, Y/N: ");
        return "Y".equals(myScanner.next());
    }

}
