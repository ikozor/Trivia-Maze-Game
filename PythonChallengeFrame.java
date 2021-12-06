import javax.swing.*;
import java.awt.*;

public class PythonChallengeFrame extends JFrame {
    public PythonChallengeFrame(){
        this.setSize(750, 750);
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
    }
}
