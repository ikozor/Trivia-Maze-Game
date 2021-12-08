import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class MainScreen extends JPanel {
    private final static int myPlayerPosition = Controller.getPlayerPos();
    private final int myMazeSize = Controller.getLevelDifficulty();
    private BufferedImage image;
    private BufferedImage exit;

    private static final JButton[] myAnswerButtons = new JButton[4];

    private static final JLabel[] myOptions = new JLabel[4];

    private static int myCurrentAnswer;
    private static boolean myAnsweredQuestion = true;



    private static JTextArea questionText;

    public MainScreen() {
        super();
        createState();
        this.setLayout(null);

    }


      public void paint(Graphics g) {
          try {
              image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("static/images/pokemon.png")));
              exit = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("static/images/exit.png")));
          } catch (IOException e) {
              e.printStackTrace();
          }
          int theWidth = 60;
          int theHeight = 60;
          super.paint(g);

         for (int i = 0; i < myMazeSize; i++){
            for (int j = 0; j < myMazeSize; j++) {
                g.drawRect(50 + (j * theWidth), 50 + (i * theHeight), theWidth-2, theHeight-2);
                g.drawImage(image, 50 , 50 , theWidth-2, theHeight-2,null);
                g.setColor(new Color(127,0,255));
                g.fillRect(50 + (j * theWidth), 50 + (i * theHeight), theWidth-2, theHeight-2);
                g.drawImage(exit,50+ ((myMazeSize - 1) * theWidth), 50 + ((myMazeSize - 1) * theHeight), theWidth-2, theHeight-2,null);
            }
        }
    }

    private static void updateQuestion(){
        if(!myAnsweredQuestion)
            return;

        Question currentQuestion = Controller.getQuestion();
        questionText.setText(currentQuestion.getMyQuestion());
        myCurrentAnswer = currentQuestion.getMyAnswer();
        for(int i = 0; i < myOptions.length; i++) {
            myOptions[i].setText(currentQuestion.getMyOptions()[i]);
            myAnswerButtons[i].setVisible(currentQuestion.getMyOptions()[i] != null);
        }
        myAnsweredQuestion = false;
    }

    private static void clearQuestion(){
        questionText.setText("");
        for (JLabel myOption : myOptions) {
            myOption.setText("");
        }
        myAnsweredQuestion = true;
    }
    private void createState() {
        JButton myRight = Components.createNewButton("Right" , 400, 100, e -> {
            updateQuestion();
        });
        this.add(myRight);

        JButton myLeft = Components.createNewButton("Left" , 400,150 , e -> {
            updateQuestion();
        });
        this.add(myLeft);

        JButton myUp = Components.createNewButton("Up" , 400, 200, e -> {
            updateQuestion();
        });
        this.add(myUp);

        JButton myDown = Components.createNewButton("Down" , 400, 250, e -> {
            updateQuestion();
        });
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

        myAnswerButtons[0] = Components.createAnswerButton("A",525,150, e ->{
            clearQuestion();
        });
        this.add(myAnswerButtons[0]);

        myAnswerButtons[1] = Components.createAnswerButton("B",525,200, e ->{
            clearQuestion();
        });
        this.add(myAnswerButtons[1]);

        myAnswerButtons[2] = Components.createAnswerButton("C",525,250, e ->{
            clearQuestion();
        });
        this.add(myAnswerButtons[2]);

        myAnswerButtons[3] = Components.createAnswerButton("D",525,300, e ->{
            clearQuestion();
        });
        this.add(myAnswerButtons[3]);


        myOptions[0] = Components.createAnswerLabel(605,120,400,100);
        this.add(myOptions[0]);

        myOptions[1] = Components.createAnswerLabel(605,170,400,100);
        this.add(myOptions[1]);

        myOptions[2] = Components.createAnswerLabel(605,220,400,100);
        this.add(myOptions[2]);

        myOptions[3] = Components.createAnswerLabel(605,270,400,100);
        this.add(myOptions[3]);

        questionText = Components.createTextArea(525, 20, 370,120);
        this.add(questionText);

        JLabel myBackground = Components.createBackground("static/images/Background_2.jpg", 1000,500);
        this.add(myBackground);


    }



}
