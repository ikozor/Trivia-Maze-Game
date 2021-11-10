import java.util.Scanner;

public class Players {
    private static final int ON_STREAK = 3;
    private String myName;
    private int myDifficultLevel;
    private int myStreak;
    //private Maze myMap; we will add this when we combine our projects


    public Players(String theName, int theLevel, int theStreak){
        myName = theName;
        myDifficultLevel = theLevel;
        myStreak  = theStreak;
    }



    public int getLevel(){
        return myDifficultLevel;
    }

    public String getName(final Scanner theSource) {
        System.out.println("Please enter your name: ");
        String name = theSource.nextLine();
        return name;
    }

    public boolean isStreakComplete() {
        return myStreak >= ON_STREAK;
    }

    public void addStreak() {
        myStreak++;
    }

    public void clearStreak() {
        myStreak = 0;
    }
}