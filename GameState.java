import java.io.*;

public class GameState{
    public static void saveGame(){
        Player player = Player.getPlayer();
        try {
            FileOutputStream file = new FileOutputStream("\"save_files\"savedGame");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(player);

            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player LoadGame(){
        Player player = null;
        try{
            FileInputStream file = new FileInputStream("\"save_files\"savedGame");
            ObjectInputStream in = new ObjectInputStream(file);

            player = (Player) in.readObject();

            in.close();
            file.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return player;
    }
}
