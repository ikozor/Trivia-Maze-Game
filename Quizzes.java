import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quizzes {
    String[] question = {
                        "Who is ...",
                        "What is...",
                        "Where...",
                        "Whose..."
                        };
    String[][] options = {
                            {"I am", "You are", "He is", "She is"},
                            {"a", "b", "c", "d"},
                            {"Apple", "Micro", "Oak", "Koffing"},
                            {"KK", "KL", "UJ", "IJ"}
                        };
    char[] answers = {
                        'A',
                        'B',
                        'C',
                        'D'
                    };
    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = question.length;
    int result;
    private JTextField textField;
    private JTextArea textArea;
    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;

    private JLabel answerLabelA;
    private JLabel answerLabelB;
    private JLabel answerLabelC;
    private JLabel answerLabelD;


    public Quizzes(){
       // createQuiz();
    }

    public void createQuiz() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setResizable(false);


        JTextField textField = Components.createTextField(70,0,150,50);
        frame.add(textField);

        JTextArea textArea = Components.createTextArea(50, 50, 400,50);
        frame.add(textArea);

        JButton buttonA = Components.createNewButton("A",10,150, e ->{});
        frame.add(buttonA);
        JButton buttonB = Components.createNewButton("B",10,200, e ->{});
        frame.add(buttonB);
        JButton buttonC = Components.createNewButton("C",10,250, e ->{});
        frame.add(buttonC);
        JButton buttonD = Components.createNewButton("D",10,300, e ->{});
        frame.add(buttonD);

        JLabel answerLabelA = Components.createLabel(120,150,200,50);
        answerLabelA.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        answerLabelA.setText("Answer 1");
        frame.add(answerLabelA);
        JLabel answerLabelB = Components.createLabel(120,170,200,100);
        answerLabelB.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        answerLabelB.setText("Answer 2");
        frame.add(answerLabelB);
        JLabel answerLabelC = Components.createLabel(120,220,200,100);
        answerLabelC.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        answerLabelC.setText("Answer 3");
        frame.add(answerLabelC);
        JLabel answerLabelD = Components.createLabel(120,270,200,100);
        answerLabelD.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        answerLabelD.setText("Answer 4");
        frame.add(answerLabelD);
        frame.setVisible(true);

        //nextQuestion();


    }

    public void nextQuestion(){
        if (index >= total_questions) {
            result();
        } else
        {
            textField.setText("Question" + (index + 1));
            textArea.setText(question[index]);
            answerLabelA.setText(options[index][0]);
            answerLabelB.setText(options[index][1]);
            answerLabelC.setText(options[index][2]);
            answerLabelD.setText(options[index][3]);
        }
    }
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = 'A';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonB) {
            answer = 'B';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonC) {
            answer = 'C';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonD) {
            answer = 'D';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }

        displayAnswer();
    }

    public void displayAnswer() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index] != 'A')
            answerLabelA.setForeground(new Color(255,0,0));
        if(answers[index] != 'B')
            answerLabelB.setForeground(new Color(255,0,0));
        if(answers[index] != 'C')
            answerLabelC.setForeground(new Color(255,0,0));
        if(answers[index] != 'D')
            answerLabelD.setForeground(new Color(255,0,0));
    }
    public void result() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = correct_guesses;


    }
}
