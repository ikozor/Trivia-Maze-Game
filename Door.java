import javax.swing.*;
import java.awt.*;

public class Door {
    private ImageIcon img = new ImageIcon("static/images/x.png");
    private Image myDoorLock;
    private Door myDoor;
    Door(){
        myDoorLock = img.getImage();
    }

    public Image getDoorLock() {
        return myDoorLock;
    }

    public Door getDoor() {
        return myDoor;
    }
}
