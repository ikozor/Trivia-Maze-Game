import javax.swing.*;
import java.awt.*;

public class RoomPanel extends JPanel {
    private final int mySize;
    private int myPlayersPos = 0;
    private Room[] myRooms;

    public RoomPanel(final int theSize){
        mySize = theSize+4;
        myRooms = new Room[mySize*mySize];

        createRooms();
        myRooms[0].setBackground(Color.white);

        this.setLayout(new GridLayout(mySize,mySize));
    }

    private void createRooms(){
        for(int i = 0; i < mySize*mySize;i++) {
            myRooms[i] = new Room();
            this.add(myRooms[i]);
        }
    }

    public void updatePlayerPos(final Directions theDir){
        myRooms[Controller.getPlayerPos()].setBackground(Color.blue);
        Controller.movePlayer(theDir);
        switch (theDir) {
            case UP -> {
                myPlayersPos -= mySize + 3;
            }
            case DOWN -> {
                myPlayersPos += mySize + 3;
            }
            case LEFT -> {
                myPlayersPos--;
            }
            case RIGHT -> {
                myPlayersPos++;
            }
        }
        myRooms[Controller.getPlayerPos()].setBackground(Color.white);
    }

    private class Room extends JButton {
        public Room(){
            this.setBackground(Color.blue);
            this.setBorder(BorderFactory.createBevelBorder(1));
            this.setEnabled(false);
        }
    }
}
