import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class MainMenu extends JPanel {
    private JButton myNewGame;
    private JButton myLoadGame;
    private JButton mySettings;
    private JTextArea myName = new JTextArea("Name");
    private JComboBox myDifficulty;
    private JButton mySubmit;
    private JButton myBack;
    private JLabel myBackground;

    public MainMenu() {
        super();
        createTitlePage();
        this.setLayout(null);

    }

    private void createTitlePage(){
        this.add(titleLabel());
        myNewGame = createButton("New Game" , 150, e -> {newGameScreen();});
        this.add(myNewGame);
        myLoadGame = createButton("Load Game" ,210, e -> {});
        this.add(myLoadGame);
        mySettings = createButton("Settings" , 270, e -> {});
        this.add(mySettings);
        mySubmit = createButton("Start" , 270, e -> {});
        this.add(mySubmit);
        myBack = createButton("Back to Menu",330, e -> {backButton();});
        this.add(myBack);

        createNewGameScreen();

        menuButtons(true);

        myBackground = createBackground();
        this.add(myBackground);
    }

    private JLabel createBackground(){
        JLabel background = new JLabel();
        ImageIcon imageIcon = new ImageIcon("static/images/main_menu_background.jpg");
        Image image = imageIcon.getImage().getScaledInstance(1000,500,java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        background.setIcon(imageIcon);
        background.setBounds(0,0,1000, 500);
        return background;

    }

    private JLabel titleLabel(){
        JLabel label = new JLabel("Python Trivia Maze");
        label.setFont(new Font(Font.DIALOG,  Font.BOLD, 60));
        label.setBounds(200,10,700,70);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JButton createButton(final String theName, final int thePosition, final ActionListener theAction){
        JButton button = new JButton(theName);
        button.setBounds(100,thePosition,200,50);
        button.setFocusable(false);
        button.addActionListener(theAction);
        button.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLUE);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setVisible(false);
        return(button);
    }

    private void createNewGameScreen(){
        myName.setBounds(100,150,200,50);
        myName.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        myName.setVisible(false);
        myDifficulty = new JComboBox(new String[]{});

        this.add(myName);
    }

    private void newGameScreen(){
        menuButtons(false);
        myName.setVisible(true);
        myBack.setVisible(true);
        mySubmit.setVisible(true);
    }

    private void backButton(){
        myName.setVisible(false);
        myBack.setVisible(false);
        mySubmit.setVisible(false);
        myBack.setVisible(false);
        //myDifficulty.setVisible(false);
        menuButtons(true);
    }

    private void menuButtons(final boolean theVisibility){
        mySettings.setVisible(theVisibility);
        myNewGame.setVisible(theVisibility);
        myLoadGame.setVisible(theVisibility);
    }
}
