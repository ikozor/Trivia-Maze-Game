import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class Players_Test {

    @Test
    void getLevel() {
        Players player1 = new Players("Player1", 3, 2);
        int level = 3;
        assertEquals(level,player1.getLevel());
    }

    @Test
    void getName() {
        Players player2 = new Players("Player2", 3, 2);
       assertEquals("Player2", player2.getName(new Scanner("Player2")));
    }

    @Test
    void isStreakComplete() {
        Players player2 = new Players("Player2", 3, 5);
        assertEquals(true, player2.isStreakComplete());
    }

    @Test
    void addStreak() {
        Players player1 = new Players("Player1", 3, 2);
        assertEquals(3, player1.addStreak());
    }

    @Test
    void clearStreak() {
        Players player1 = new Players("Player1", 3, 2);
        assertEquals(0, player1.clearStreak());
    }
}