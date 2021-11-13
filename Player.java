import java.util.Scanner;
/**
 *  This class describes about players (name, the difficult level, the Streak,..).
 *
 * @author Rin Pham
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */
public class Player {
    private static final int ON_STREAK = 3;
    private String myName;
    private int myDifficultLevel;
    private int myStreak = 0;
    private Maze myMap;
    private int myPosition = 1;


    /**
     * Constructor
     * @param theName indicates player's name.
     * @param theLevel indicates the difficult level of the game.
     */
    public Player(String theName, int theLevel){
        myName = theName;
        myDifficultLevel = theLevel;
        myMap = new Maze((int)Math.pow(theLevel + 3, 2));
    }

    /**
     * This method gets the difficult level.
     * @return an integer as the difficult level of the game.
     */
    public int getLevel(){
        return myDifficultLevel;
    }

    /**
     *  This method gets the player's name.
     * @param theSource get the player's name from users.
     * @return a String as the player's name
     */
    public String getName(final Scanner theSource) {
        System.out.println("Please enter your name: ");
        String name = theSource.nextLine();
        return name;
    }

    /**
     * This method checks if players complete the streak.
     * @return boolean as yes or no
     */
    public boolean isStreakComplete() {
        return myStreak >= ON_STREAK;
    }

    /**
     * This methods adds more streaks.
     */
    public void addStreak() {
        myStreak++;
    }

    /**
     * This method clears streaks.
     */
    public void clearStreak() {
        myStreak = 0;
    }

    public int getPlayerPosition(){
        return myPosition;
    }

    /**
     * moves the player through the maze
     *
     * @param theDir as the direction the player wants to move
     */
    public void movePlayer(final Directions theDir){
        switch (theDir){
            case UP -> {
                if(attemptMove(myPosition-(myDifficultLevel+3)))
                    myPosition -= myDifficultLevel+3;
            }
            case DOWN -> {
                if(attemptMove(myPosition+(myDifficultLevel+3)))
                    myPosition += myDifficultLevel+3;
            }
            case LEFT -> {
                if(attemptMove(myPosition-1))
                    myPosition--;
            }
            case RIGHT -> {
                if(attemptMove(myPosition+1))
                    myPosition++;
            }
        }
        System.out.println("Position: " + myPosition);
    }

    private boolean attemptMove(final int theWhere){
        if(myMap.canGoto(myPosition , theWhere)) {
            //Will ASK QUESTION ON THE GUI
            //THIS IS FOR TEMP WHILE WE DO NOT HAVE QUESTIONS
            if(!tempCLI.askQuestion()) {
                myMap.closeDoor(myPosition, theWhere);
                System.out.println(myMap.toString());
                return false;
            }
            return true;
        }
        return false;
    }



}