import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Main Menu Screen
 *
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */
public class MainMenu extends JPanel {
    private final JTextArea myName = new JTextArea("Name");
    private JComboBox<String> myDifficulty;
    private JButton mySubmit;
    private static final String myBackgroundMain = "static/images/main_menu_background.jpg";

    /**
     * Constructor for Creating the Main Menu
     */
    public MainMenu() {
        super();
        createTitlePage();
        this.add(CreateComponents.createBackground(myBackgroundMain,1000,500));
        this.setLayout(null);

    }

    /**
     * Creates the Title Page with all the components of the Main Menu Screen
     */
    private void createTitlePage(){
        this.add(CreateComponents.createTitleLabel("Python Trivia Game"));
        JButton myNewGame = CreateComponents.createButton("New Game", 100, 150, e -> {});
        this.add(myNewGame);
        JButton myLoadGame = CreateComponents.createButton("Load Game", 100, 210, e -> {});
        File temp = new File("save_files\\savedGame");
        if(!temp.exists())
            myLoadGame.setEnabled(false);
        this.add(myLoadGame);
        JButton mySettings = CreateComponents.createButton("Settings", 100, 270, e -> {new Settings();});
        this.add(mySettings);
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
}
