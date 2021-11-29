import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JPanel {
    private JButton mySetting;
    private JButton mySave;
    private JButton myExit;
    private JButton myRight;
    private JButton myLeft;
    private JButton myUp;
    private JButton myDown;
    private JLabel myStreak;
    private JLabel myStreakNumber;
    private JLabel myBackground;


    public GUI() {
        super();
        createState();
        this.setLayout(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(213, 224, 197));
        g.fillRect(150,10,400,400);
    }

    private void createState() {
        myRight = Components.createNewButton("Right" , 700, 100, e -> {});
        this.add(myRight);
        myLeft = Components.createNewButton("Left" , 700,150 , e -> {});
        this.add(myLeft);
        myUp = Components.createNewButton("Up" , 700, 200, e -> {});
        this.add(myUp);
        myDown = Components.createNewButton("Down" , 700, 250, e -> {});
        this.add(myDown);

        mySetting = Components.createNewButton("Setting" , 600, 400, e -> {});
        this.add(mySetting);
        mySave = Components.createNewButton("Save" , 705,400 , e -> {});
        this.add(mySave);
        myExit = Components.createNewButton("Exit" , 810, 400, e -> {});
        this.add(myExit);

        myStreak = Components.createLabel("Streak:", 300,400,100,50);
        this.add(myStreak);
        myStreakNumber = Components.createLabel("0", 400,400,100,50);
        this.add(myStreakNumber);

        myBackground = createBackground();
        this.add(myBackground);
    }
    
    private JLabel createBackground(){
        JLabel background = new JLabel();
        ImageIcon imageIcon = new ImageIcon("Background_2.jpg");
        Image image = imageIcon.getImage().getScaledInstance(1000,500,java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        background.setIcon(imageIcon);
        background.setBounds(0,0,1000, 500);
        background.setVisible(true);
        this.add(background);
        return background;

    }

}
