import java.io.Serializable;
import java.util.HashSet;

/**
 *  This class describes about myPlayers (name, the difficult level, the Streak,..).
 *
 * @author Rin Pham
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */
public class Player implements Serializable {

    private boolean myLostGame = false;
    private static final int ON_STREAK = 3;
    private final String myName;
    private final Difficulty myDifficultLevel;
    private int myStreak = 0;
    private final Maze myMap;
    private int myPosition = 0;
    private final HashSet<Integer> myRoomsUnlocked = new HashSet<>();
    private static Player myPlayer;


    /**
     * Constructor
     * @param theName indicates myPlayer's name.
     * @param theLevel indicates the difficult level of the game.
     */
    private Player(String theName, Difficulty theLevel){
        myName = theName;
        myDifficultLevel = theLevel;
        myMap = new Maze((int)Math.pow(theLevel.getValue() + 3, 2));
        myRoomsUnlocked.add(0);
    }

    /**
     * Checks if player has lost the game
     *
     * @return boolean if game was lost
     */
    public boolean isMyGameLost(){
        return myLostGame;
    }

    /**
     * Create a new player with the base location of 0. Player creation is based on name and level
     *
     * @param theName indicates myPlayer's name.
     * @param theLevel indicates the difficult level of the game.
     *
     */
    public static void createPlayer(String theName, Difficulty theLevel){
        if(myPlayer == null)
            myPlayer = new Player(theName,theLevel);
    }

    /**
     * Loads a game and stores loaded information on new player
     *
     * @param theObjectState an object as the player that was saved
     */
    public static void loadPlayer(final Object theObjectState){
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
    public  Difficulty getLevel(){
        return
                myDifficultLevel;
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
        int tempPosition = myPosition;
        switch (theDir){
            case UP -> {
                tempPosition -= myDifficultLevel.getValue()+3;
            }
            case DOWN -> {
                tempPosition += myDifficultLevel.getValue()+3;
            }
            case LEFT -> {
                tempPosition--;
            }
            case RIGHT -> {
                tempPosition++;
            }
        }
        if(myMap.canGoto(myPosition,tempPosition)){
            myPosition = tempPosition;
        }
    }

    /**
     * see if the myPlayer can move in a certain direction and asks the question
     *
     * @param theWhere as an integer where the myPlayer is trying to move
     *
     * @return boolean true/false if the myPlayer can move there
     */
    private boolean attemptMove(final int theWhere, final boolean theAskQuestion) {
        return myMap.canGoto(myPosition, theWhere);
    }

    public void setPlayerPosition(final int thePos){
        myPosition = thePos;
    }



}