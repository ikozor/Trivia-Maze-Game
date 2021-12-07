import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainScreen extends JPanel {
    private static int myPlayerPos;
    private
    static int myMazeSize = 5;
    private BufferedImage image;
    private BufferedImage exit;


    public MainScreen() {
        super();
        createState();

        this.setLayout(null);

    }


      public void paint(Graphics g) {
          try {
              image = ImageIO.read(getClass().getResourceAsStream("static/images/pokemon.png"));
              exit = ImageIO.read(getClass().getResourceAsStream("static/images/exit.png"));
          } catch (IOException e) {
              e.printStackTrace();
          }
          int theWidth = 60;
          int theHeight = 60;
          super.paint(g);
         // g.setColor(Color.WHITE);
         // g.fillOval(50 * (2), 50 * (2), theWidth-2, theHeight-2);
         // g.drawImage(image, 50 * (2), 50 * (2), theWidth-2, theHeight-2,null);

         for (int i = 0; i < myMazeSize; i++){
            for (int j = 0; j < myMazeSize; j++) {
               // g.setColor(Color.BLACK);
                //g.drawRect(50 * ( 2), 50 * (2), theWidth * myMazeSize, theHeight * myMazeSize);

               // g.drawRect(50 * (j + 2), 50 * (i + 2), theWidth-2, theHeight-2);
                g.drawRect(50 + (j * theWidth), 50 + (i * theHeight), theWidth-2, theHeight-2);

                g.drawImage(image, 50 , 50 , theWidth-2, theHeight-2,null);
                g.setColor(new Color(127,0,255));
                g.fillRect(50 + (j * theWidth), 50 + (i * theHeight), theWidth-2, theHeight-2);
               // g.setColor(Color.RED);
               // g.fillRect(50+ ((myMazeSize - 1) * theWidth), 50 + ((myMazeSize - 1) * theHeight), theWidth-2, theHeight-2);
                g.drawImage(exit,50+ ((myMazeSize - 1) * theWidth), 50 + ((myMazeSize - 1) * theHeight), theWidth-2, theHeight-2,null);
            }
        }
    }

    private void createState() {
        JButton myRight = Components.createNewButton("Right" , 450, 100, e -> {});
        this.add(myRight);
        JButton myLeft = Components.createNewButton("Left" , 450,150 , e -> {});
        this.add(myLeft);
        JButton myUp = Components.createNewButton("Up" , 450, 200, e -> {});
        this.add(myUp);
        JButton myDown = Components.createNewButton("Down" , 450, 250, e -> {});
        this.add(myDown);

        JButton mySetting = Components.createNewButton("Setting" , 600, 400, e -> {});
        this.add(mySetting);
        JButton mySave = Components.createNewButton("Save" , 705,400 , e -> {});
        this.add(mySave);
        JButton myExit = Components.createNewButton("Exit" , 810, 400, e -> {});
        this.add(myExit);

        JLabel myStreak = Components.createLabel(150,410,100,50);
        myStreak.setText("Streak");
        this.add(myStreak);
        JLabel myStreakNumber = Components.createLabel( 250,410,100,50);
        myStreakNumber.setText("0");
        this.add(myStreakNumber);

        JButton buttonA = Components.createAnswerButton("A",600,100, e ->{});
        this.add(buttonA);
        JButton buttonB = Components.createAnswerButton("B",600,150, e ->{});
        this.add(buttonB);
        JButton buttonC = Components.createAnswerButton("C",600,200, e ->{});
        this.add(buttonC);
        JButton buttonD = Components.createAnswerButton("D",600,250, e ->{});
        this.add(buttonD);

        JLabel answerLabelA = Components.createAnswerLabel(700,70,400,100);
        answerLabelA.setText("Answer 1");
        this.add(answerLabelA);
        JLabel answerLabelB = Components.createAnswerLabel(700,120,400,100);
        answerLabelB.setText("Answer 2");
        this.add(answerLabelB);
        JLabel answerLabelC = Components.createAnswerLabel(700,170,400,100);
        answerLabelC.setText("Answer 3");
        this.add(answerLabelC);
        JLabel answerLabelD = Components.createAnswerLabel(700,220,400,100);
        answerLabelD.setText("Answer 4");
        this.add(answerLabelD);

        JTextArea textArea = Components.createTextArea(600, 20, 370,70);
        this.add(textArea);

        JLabel myBackground = Components.createBackground("static/images/Background_2.jpg", 1000,500);
        this.add(myBackground);

        /*JComboBox myHelp = new JComboBox<>(new String[]{"About","Instructions","Cheats"});

        myHelp.setBounds(10,10,200,50);
        myHelp.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        myHelp.setBackground(Color.WHITE);
        myHelp.setVisible(true);
        this.add(myHelp);*/
    }



}
