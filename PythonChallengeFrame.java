import javax.swing.*;
import java.awt.*;

public class PythonChallengeFrame extends JFrame {
    public PythonChallengeFrame(){
        this.add(createScreen());
        this.setSize(750, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);

        //REMOVE THIS
    }

    private JPanel createScreen(){

        JPanel panel = new JPanel();
        panel.add(Components.createTitleLabel(50,"CODING CHALLENGE"));
        //panel.add(Components.createLabel(10,200,700,100));
        panel.add(Components.createBackground("static/images/Settings_background.jpg",750,500));

        String[] challenge = Controller.getChallenge();
        String name = challenge[0];
        String answer = challenge[1];
        String challengeText = challenge[2];
        String params = challenge[3];

        panel.add(Components.createLabel(50,200,650,100));

        panel.setLayout(null);
        return panel;
    }

}
