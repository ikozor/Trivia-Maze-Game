import java.io.Serializable;

/**
 *  This class describes about myPlayers (name, the difficult level, the Streak,..).
 *
 * @author Rin Pham
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */
public class Player implements Serializable {
    private static final int ON_STREAK = 3;
    private String myName;
    private int myDifficultLevel;
    private int myStreak = 0;
    private Maze myMap;
    private int myPosition = 0;
    private boolean[] myRoomsUnlocked;
    private static Player myPlayer;


    /**
     * Constructor
     * @param theName indicates myPlayer's name.
     * @param theLevel indicates the difficult level of the game.
     */
    private Player(String theName, int theLevel){
        myName = theName;
        myDifficultLevel = theLevel;
        myMap = new Maze((int)Math.pow(theLevel + 3, 2));
        myRoomsUnlocked = new boolean[(int)Math.pow(theLevel + 3, 2)];
        myRoomsUnlocked[0] = true;
    }

    /**
     * Create a new myPlayer if a myPlayer does not already exist
     *
     * @param theName indicates myPlayer's name.
     * @param theLevel indicates the difficult level of the game.
     *
     * @return the new created or existing myPlayer
     */
    public static Player createPlayer(String theName, int theLevel){
        if(myPlayer == null)
            myPlayer = new Player(theName,theLevel);
        return myPlayer;
    }

    public static void createPlayer(final Object theObjectState){
        myPlayer = (Player) theObjectState;
    }

    /**
     * Delete the current myPlayer
     */
    public static void deletePlayer(){
        if(myPlayer != null)
            myPlayer = null;
    }

    /**
     * Return the current existing myPlayer
     *
     * @return myPlayer as the existing myPlayer
     */
    public static Player getPlayer(){
        return myPlayer;
    }

    /**
     * This method gets the difficult level.
     * @return an integer as the difficult level of the game.
     */
    public int getLevel(){
        return myDifficultLevel;
    }

    /**
     *  This method gets the myPlayer's name.
     *
     * @return a String as the myPlayer's name
     */
    public String getName() {
        return myName;
    }

    /**
     * This method checks if myPlayers complete the streak.
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
     * moves the myPlayer through the maze
     *
     * @param theDir as the direction the myPlayer wants to move
     */
    public void movePlayer(final Directions theDir , final boolean theAskQuestion){
        switch (theDir){
            case UP -> {
                if(attemptMove(myPosition-(myDifficultLevel+3),theAskQuestion))
                    myPosition -= myDifficultLevel+3;
            }
            case DOWN -> {
                if(attemptMove(myPosition+(myDifficultLevel+3),theAskQuestion))
                    myPosition += myDifficultLevel+3;
            }
            case LEFT -> {
                if(attemptMove(myPosition-1,theAskQuestion))
                    myPosition--;
            }
            case RIGHT -> {
                if(attemptMove(myPosition+1,theAskQuestion))
                    myPosition++;
            }
        }
    }
    /**
     * see if the myPlayer can move in a certain direction and asks the question
     *
     * @param theWhere as an integer where the myPlayer is trying to move
     *
     * @return boolean true/false if the myPlayer can move there
     */
    private boolean attemptMove(final int theWhere, final boolean theAskQuestion){
        if(myMap.canGoto(myPosition , theWhere)) {

            //Will ASK QUESTION ON THE GUI
            //THIS IS FOR TEMP WHILE WE DO NOT HAVE QUESTIONS
            if (theAskQuestion && !myRoomsUnlocked[theWhere]) {
                if (!tempCLI.askQuestion()) {
                    myMap.closeDoor(myPosition, theWhere);
                    return false;
                }
            }
            myRoomsUnlocked[theWhere] = true;
            return true;
        }
        return false;
    }

    public void setPlayerPosition(final int thePos){
        myPosition = thePos;
    }



}