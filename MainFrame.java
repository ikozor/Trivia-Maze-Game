import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private static JFrame myFrame;

    /**
     * Creates a new frame
     */
    public MainFrame(){
        myFrame = new JFrame();
        myFrame.add(new MainMenu());
        myFrame.setSize(1000, 500);
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        myFrame.setLocation(dim.width/2-myFrame.getSize().width/2, dim.height/2-myFrame.getSize().height/2);
        myFrame.setVisible(true);
    }
}
