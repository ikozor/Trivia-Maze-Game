import java.io.*;

public class GameState{

    /**
     * Saves the current state of the game using Serialization
     */
    public static void saveGame(){
        try {
            FileOutputStream file = new FileOutputStream("save_files\\savedGame");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(Player.getPlayer());

            out.close();
            file.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Loads the game you have on file through Deserialization
     */
    public static void loadGame(){

        try{
            FileInputStream file = new FileInputStream("save_files\\savedGame");
            ObjectInputStream in = new ObjectInputStream(file);

            Player.loadPlayer(in.readObject());

            in.close();
            file.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes old game and creates a new one based on the parameters
     *
     * @param theName The name of the player
     * @param theDifficulty the Difficulty of the game
     */
    public static void newGame(final String theName, final int theDifficulty){
        Player.deletePlayer();
        Player.createPlayer(theName,theDifficulty);
    }
    public static void endGame(){
        Player.deletePlayer();
    }
}
