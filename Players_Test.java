import org.junit.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class Players_Test {

    @Test
    void getLevel() {
        Player player1 = new Player("Player1", 3);
        int level = 3;
        assertEquals(level,player1.getLevel());
    }

    @Test
    void getName() {
        Player player2 = new Player("Player2", 3);
       assertEquals("Player2", player2.getName(new Scanner("Player2")));
    }

    @Test
    void isStreakComplete() {
        Player player2 = new Player("Player2", 3);
        assertEquals(true, player2.isStreakComplete());
    }

    @Test
    void addStreak() {
        Player player1 = new Player("Player1", 3);

        assertEquals(1, player1.addStreak());
    }

    @Test
    void clearStreak() {
        Player player1 = new Player("Player1", 3);
        assertEquals(0, player1.clearStreak());
    }

    @Test
    void getPlayerPosition(){
        Player player3 = new Player("player3",3);
        int currentPosition = 1;
        assertEquals(currentPosition, player3.getPlayerPosition());

    }
}