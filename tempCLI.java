import java.util.Scanner;

public class tempCLI {
    static Scanner scanner = new Scanner(System.in);
    Player player;

    public tempCLI(int d){
        player = Player.createPlayer("Bill" , d);
        while(player.getPlayerPosition() != Math.pow(d+3, 2)-1){
            System.out.println("Move in direction, UP/DOWN/LEFT/RIGHT: ");

            player.movePlayer(Directions.valueOf(scanner.next()),true );
            if(player.isMyGameLost())
                System.exit(0);
        }
    }
    public static boolean askQuestion(){
        //pull random question and ask question
        System.out.println("Answer correct, Y/N: ");
        return "Y".equals(scanner.next());
    }

}
