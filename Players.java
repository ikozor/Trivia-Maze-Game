public class Players {
    private String name;
    private int difficultLevel;
    private int streak;
    private Maze map;


    public Players(String theName, int theLevel, int theStreak){
        name = theName;
        difficultLevel = theLevel;
        streak = theStreak;
    }
    private int getLevel(){
        return 1;
    }

    private  String getName() {

    return name;
    }

    private boolean completeStreak() {

        return true;
    }

    private void addStreak() {

    }

    private void clearStreak() {

    }
}