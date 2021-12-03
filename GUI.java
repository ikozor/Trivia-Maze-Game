import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {


    public GUI() {
        super();
        createState();
        this.setLayout(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(213, 224, 197));
        g.fillRect(15,15,400,400);
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

        JTextField textField = Components.createTextField(600,20,350,50);
        //this.add(textField);
        JTextArea textArea = Components.createTextArea(600, 20, 370,70);
        this.add(textArea);

        //JLabel myBackground = Components.createBackground();
        //this.add(myBackground);
    }



}
