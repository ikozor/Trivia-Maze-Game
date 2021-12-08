import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * The frame where the important components of the game will be (Main Menu and Game Screen)
 *
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */

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

    public static void closeFrame(){
        myFrame.dispose();
    }

    public static void goToGame(){
        myFrame = new JFrame();
        myFrame.setTitle("Trivia Maze Game");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(1000, 500);
        myFrame.add(new MainScreen());

        myFrame.setVisible(true);
        myFrame.setResizable(false);
    }
}
