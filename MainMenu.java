import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Main Menu Screen
 *
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */
public class MainMenu extends JPanel {
    private JButton myNewGame;
    private JButton myLoadGame;
    private JButton mySettings;
    private final JTextArea myName = new JTextArea("Name");
    private JComboBox<String> myDifficulty;
    private JButton mySubmit;
    private JButton myBack;
    private JLabel myBackground;

    /**
     * Constructor for Creating the Main Menu
     */
    public MainMenu() {
        super();
        createTitlePage();
        this.setLayout(null);

    }

    /**
     * Creates the Title Page with all the components of the Main Menu Screen
     */
    private void createTitlePage(){
        this.add(titleLabel());
        myNewGame = createButton("New Game" , 150, e -> {newGameScreen();});
        this.add(myNewGame);
        myLoadGame = createButton("Load Game" ,210, e -> {});
        File temp = new File("save_files\\savedGame");
        if(!temp.exists())
            myLoadGame.setEnabled(false);
        this.add(myLoadGame);
        mySettings = createButton("Settings" , 270, e -> {});
        this.add(mySettings);

        mySubmit = createButton("Start" , 270, e -> {});
        this.add(mySubmit);
        myBack = createButton("Back",330, e -> {backButton();});
        this.add(myBack);

        createNewGameScreen();

        menuButtons(true);

        myBackground = createBackground();
        this.add(myBackground);
    }

    /**
     * Creates the Background for the title page\
     *
     * @return A JLabel as the background
     */
    private JLabel createBackground(){
        JLabel background = new JLabel();
        ImageIcon imageIcon = new ImageIcon("static/images/main_menu_background.jpg");
        Image image = imageIcon.getImage().getScaledInstance(1000,500,java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        background.setIcon(imageIcon);
        background.setBounds(0,0,1000, 500);
        return background;

    }

    /**
     * Creates the Title for the Title Page
     *
     * @return a JLabel for the Title
     */
    private JLabel titleLabel(){
        JLabel label = new JLabel("Python Trivia Maze");
        label.setFont(new Font(Font.DIALOG,  Font.BOLD, 60));
        label.setBounds(200,10,700,70);
        label.setForeground(Color.WHITE);
        return label;
    }

    /**
     * Creates a new Button based on the parameters
     *
     * @param theName as the text of the button
     * @param thePosition the y position of the button
     * @param theAction what the button is supposed to do
     *
     * @return a new JButton
     */
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

    /**
     * The Screen that will display if user wants to create a new game
     */
    private void createNewGameScreen(){
        myName.setBounds(100,150,200,50);
        myName.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        myName.setVisible(false);

        myDifficulty = new JComboBox<>(new String[]{"Easy","Medium","Hard"});
        myDifficulty.setBounds(100,210,200,50);
        myDifficulty.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        myDifficulty.setBackground(Color.WHITE);
        myDifficulty.setVisible(false);

        this.add(myDifficulty);
        this.add(myName);
    }

    /**
     * Make the New game components visible
     */
    private void newGameScreen(){
        menuButtons(false);
        myName.setVisible(true);
        myBack.setVisible(true);
        mySubmit.setVisible(true);
        myDifficulty.setVisible(true);
    }

    /**
     * If user presses the back button, make only main menu options visible
     */
    private void backButton(){
        myName.setVisible(false);
        myBack.setVisible(false);
        mySubmit.setVisible(false);
        myBack.setVisible(false);
        myDifficulty.setVisible(false);
        menuButtons(true);
    }

    /**
     * Change visibility of the Main Menu buttons based on the parameters
     *
     * @param theVisibility a boolean if the Menu options should be visible
     */
    private void menuButtons(final boolean theVisibility){
        mySettings.setVisible(theVisibility);
        myNewGame.setVisible(theVisibility);
        myLoadGame.setVisible(theVisibility);
    }
}
