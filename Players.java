import java.util.Scanner;
/**
 *  This class describes about players (name, the difficult level, the Streak,..).
 */
public class Players {
    private static final int ON_STREAK = 3;
    private String myName;
    private int myDifficultLevel;
    private int myStreak;
    //private Maze myMap; we will add this when we combine our projects

    /**
     * Constructor
     * @param theName indicates player's name.
     * @param theLevel indicates the difficult level of the game.
     * @param theStreak indicates the number of streak.
     */
    public Players(String theName, int theLevel, int theStreak){
        myName = theName;
        myDifficultLevel = theLevel;
        myStreak  = theStreak;
    }

    /**
     * This method gets the difficult level.
     * @return the difficult level of the game.
     */
    public int getLevel(){
        return myDifficultLevel;
    }

    /**
     *  This method gets the player's name.
     * @param theSource get the player's name from users.
     * @return the player's name
     */
    public String getName(final Scanner theSource) {
        System.out.println("Please enter your name: ");
        String name = theSource.nextLine();
        return name;
    }

    /**
     * This method checks if players complete the streak.
     * @return yes or no
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
}