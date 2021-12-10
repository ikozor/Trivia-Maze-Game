
import javax.swing.*;


public class MainScreen extends JPanel {
    private final int myMazeSize;

    RoomPanel roomPanel;

    private static final int myStreak = 0;
    private static final int STREAK_COMPLETE = 5;

    private static final int myScore = 0;

    private static final JButton[] myAnswerButtons = new JButton[4];
    private static final JLabel[] myOptions = new JLabel[4];
    private static Question myCurrentQuestion;

    private static final JButton[] myMoveButtons = new JButton[4];
    private static final Directions[] myDirections = new Directions[]{Directions.RIGHT,Directions.LEFT,Directions.UP,Directions.DOWN};
    private static Directions myAttemptMove;

    private static int myCurrentAnswer;
    private static boolean myAnsweredQuestion = true;



    private static JTextArea questionText;

    public MainScreen(final int theSize) {
        super();
        createState();
        myMazeSize = theSize;
        this.setLayout(null);

    }



    private void updateQuestion(){
        if(!myAnsweredQuestion)
            return;

        myCurrentQuestion = Controller.getQuestion();
        questionText.setText(myCurrentQuestion.getMyQuestion());
        myCurrentAnswer = myCurrentQuestion.getMyAnswer();
        for(int i = 0; i < 4; i++) {
            myOptions[i].setText(myCurrentQuestion.getMyOptions()[i]);
            myAnswerButtons[i].setVisible(myCurrentQuestion.getMyOptions()[i] != null);
        }
        myAnsweredQuestion = false;
    }

    private void clearQuestion(){
        questionText.setText("");
        for (int i = 0; i < 4; i++) {
            myOptions[i].setText("");
            myMoveButtons[i].setVisible(Controller.canPlayerGo(myDirections[i]));
        }
        myAnsweredQuestion = true;
    }

    private void limitMovement(){
        for (int i = 0; i < 4; i++) {
            myMoveButtons[i].setVisible(Controller.canPlayerGo(myDirections[i]));
        }
    }

    private void checkAnswer(final int theChoice){
        clearQuestion();
        if(myCurrentQuestion.getMyAnswer() == theChoice)
            roomPanel.updatePlayerPos(myAttemptMove);
        else
            isGameLost();

        limitMovement();

    }

    private void isGameLost(){
        if(!Controller.answeredWrong(myAttemptMove)) {
            JOptionPane.showMessageDialog(this, "You Have Lost!\n You will be directed to the main menu", "Game Lost", JOptionPane.WARNING_MESSAGE);
            Controller.resetQuestions();
            MainFrame.closeFrame();
            MainFrame.goTo(new MainMenu());
            Controller.resetQuestions();
        }
    }

    private void movePlayer(final Directions theDir){
        updateQuestion();
        myAttemptMove = theDir;


    }
    private void createState() {
        roomPanel = new RoomPanel(myMazeSize);
        roomPanel.setBounds(10,10,400,400);
        this.add(roomPanel);

        myMoveButtons[0] = Components.createNewButton("Right" , 420, 100, e -> {
            movePlayer(Directions.RIGHT);
        });
        this.add(myMoveButtons[0]);

        myMoveButtons[1] = Components.createNewButton("Left" , 420,150 , e -> {
            movePlayer(Directions.LEFT);
        });
        this.add(myMoveButtons[1]);

        myMoveButtons[2] = Components.createNewButton("Up" , 420, 200, e -> {
            movePlayer(Directions.UP);
        });
        this.add(myMoveButtons[2]);

        myMoveButtons[3] = Components.createNewButton("Down" , 420, 250, e -> {
            movePlayer(Directions.DOWN);
        });
        this.add(myMoveButtons[3]);

        limitMovement();


        JButton setting = Components.createNewButton("Setting" , 600, 400, e -> {
            new Settings();
        });
        this.add(setting);


        JButton save = Components.createNewButton("Save" , 705,400 , e -> {
            Controller.saveGame();
        });
        this.add(save);

        JButton exit = Components.createNewButton("Exit" , 810, 400, e -> {
            MainFrame.closeFrame();
            Controller.quitGame();

        });
        this.add(exit);

        JLabel streakLabel = Components.createLabel(200,410,150,50);
        streakLabel.setText("Streak: "+myStreak);
        this.add(streakLabel);

        JLabel scoreLabel = Components.createLabel(10,410,150,50);
        scoreLabel.setText("Score: "+myScore);
        this.add(scoreLabel);



        myAnswerButtons[0] = Components.createAnswerButton("A",525,150, e ->{ checkAnswer(0);});
        this.add(myAnswerButtons[0]);

        myAnswerButtons[1] = Components.createAnswerButton("B",525,200, e ->{ checkAnswer(1);});
        this.add(myAnswerButtons[1]);

        myAnswerButtons[2] = Components.createAnswerButton("C",525,250, e ->{ checkAnswer(2);});
        this.add(myAnswerButtons[2]);

        myAnswerButtons[3] = Components.createAnswerButton("D",525,300, e ->{ checkAnswer(3);});
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
