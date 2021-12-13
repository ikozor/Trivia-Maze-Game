import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.GridLayout;

/**
 * A manager of the questions for the regular maze
 *
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */

public class RoomPanel extends JPanel {
    private final int mySize;
    private int myPlayersPos;
    private Room[] myRooms;

    /**
     * Constructor
     *
     * @param theSize the size of the maze
     */
    public RoomPanel(final int theSize){
        mySize = theSize+3;
        myRooms = new Room[mySize*mySize];

        createRooms();
        for (int i  : Controller.getRoomsUnlocked())
            myRooms[i].setBackground(Color.green);

        myRooms[Controller.getPlayerPos()].setBackground(Color.white);
        this.setLayout(new GridLayout(mySize,mySize));
    }

    /**
     * Create the rooms
     */
    private void createRooms(){
        Directions[] dirs = new Directions[]{Directions.UP,Directions.DOWN,Directions.LEFT,Directions.RIGHT};
        int savePos = Controller.getPlayerPos();
        for(int i = 0; i < mySize*mySize;i++) {
            myRooms[i] = new Room();
            this.add(myRooms[i]);
            Controller.setPlayerPos(i);
            myPlayersPos = Controller.getPlayerPos();
            for(Directions dir : dirs){
                if(!Controller.canPlayerGo(dir))
                    lockRoom(dir);
            }
        }
        Controller.setPlayerPos(savePos);
        myPlayersPos = Controller.getPlayerPos();
    }

    /**
     * get the int value of the position
     *
     * @param theDir the direction from the player to get the room value
     *
     * @return the int value of that room
     */
    private int getPos(final Directions theDir){
        int tempPos = myPlayersPos;
        switch (theDir) {
            case UP -> {
                tempPos -= mySize;
            }
            case DOWN -> {
                tempPos += mySize;
            }
            case LEFT -> {
                tempPos--;
            }
            case RIGHT -> {
                tempPos++;
            }
        }
        return tempPos;
    }

    /**
     * updated the player position
     *
     * @param theDir the direction to move the player
     */
    public void updatePlayerPos(final Directions theDir){
        myRooms[Controller.getPlayerPos()].unlock();
        myPlayersPos = getPos(theDir);
        Controller.movePlayer(theDir);

        myRooms[Controller.getPlayerPos()].setBackground(Color.white);
    }

    /**
     * locks room in a certain direction
     *
     * @param theDir the direction to lock the door
     */
    public void lockRoom(final Directions theDir){
        myRooms[myPlayersPos].updateLockedSides(theDir);
        int[] lockedRooms = myRooms[myPlayersPos].getLockedSides();
        myRooms[myPlayersPos].setBorder(new MatteBorder(lockedRooms[0],lockedRooms[2],lockedRooms[1],lockedRooms[3],Color.black));


    }

    /**
     * Nested class
     */
    private class Room extends JButton {
        private int[] myLockedSides = new int[]{1,1,1,1};

        /**
         * Constructor
         */
        public Room(){
            this.setBackground(Color.blue);
            this.setBorder(BorderFactory.createBevelBorder(1));
            this.setEnabled(false);
        }

        /**
         * unlock a certain room
         */
        public void unlock(){
            this.setBackground(Color.green);
        }

        /**
         * add border if room is locked
         * @param theDir the direction to lock
         */
        public void updateLockedSides(final Directions theDir){
            myLockedSides[theDir.getValue()] += 10;
        }

        /**
         *
         * @return an int array of locked sides for each room
         */
        public int[] getLockedSides() {
            return myLockedSides;
        }
    }

}
