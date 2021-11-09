import java.util.Scanner;

public class Players {
    private String myName;
    private int myDifficultLevel;
    private int myStreak;
    private Maze myMap;


    public Players(String theName, int theLevel, int theStreak){
        myName = theName;
        myDifficultLevel = theLevel;
        myStreak  = theStreak;
    }



    private int getLevel(){
        return 1;
    }

    private  String getName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
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