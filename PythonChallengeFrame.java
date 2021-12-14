import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The separate frame where the python challenge will take place
 *
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */

public class PythonChallengeFrame extends JFrame {

    /**
     * Constructor
     * <p>
     * Creates the frame, and add all necessary components
     */
    public PythonChallengeFrame() {
        this.add(createScreen());
        this.setSize(750, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
    }

    /**
     * Create the panel where the challenge will take place
     *
     * @return a JPanel where the challenge takes place
     */
    private JPanel createScreen() {

        JPanel panel = new JPanel();
        panel.add(Components.createTitleLabel(50, "CODING CHALLENGE"));

        String[] challenge = Controller.getChallenge();
        String name = challenge[0];
        String challengeText = challenge[2];
        String params = challenge[3];

        JTextArea IDE = createIDE(name, params);


        panel.add(Components.createNewButton("Run", 625, 390, e -> {
            createFile(IDE.getText());
            displayResult(Controller.getChallengeResult());
        }));

        panel.add(createChallengeText(challengeText));

        panel.add(IDE);

        panel.add(Components.createBackground("static/images/Settings_background.jpg", 750, 500));
        panel.setLayout(null);
        return panel;
    }


    /**
     * Returns the description of the challenge
     *
     * @param theText a String as the description of the challenge
     * @return JTextArea, as the description to be added to the panel
     */
    private JTextArea createChallengeText(String theText) {
        JTextArea ch = new JTextArea(theText);
        ch.setBounds(50, 80, 650, 50);
        ch.setEditable(false);
        ch.setOpaque(false);
        ch.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        ch.setForeground(Color.white);
        ch.setLineWrap(true);
        return ch;
    }

    /**
     * Creates the text editor to write the python code with the function and params already defined\
     *
     * @param theName   a String as the name of the function
     * @param theParams a String as the parameters of the function
     * @return a JTextArea as the text editor where the user can write the code
     */
    private JTextArea createIDE(final String theName, final String theParams) {
        JTextArea ide = new JTextArea("def " + theName + "(" + theParams + "):\n");
        ide.setBounds(50, 135, 600, 300);
        ide.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        ide.setForeground(Color.WHITE);
        ide.setBackground(Color.BLACK);
        return ide;
    }

    /**
     * Writes from the IDE to the python file
     *
     * @param theCode the text from the IDE
     */
    private void createFile(final String theCode) {
        try {
            FileWriter writer = new FileWriter("python_challenges/Challenge.py");
            writer.write(theCode);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Display whether the results of the python code is correct according to the challenge
     *
     * @param theResult a boolean if the code was correct
     */
    private void displayResult(final boolean theResult) {
        if (!theResult)
            JOptionPane.showMessageDialog(this, "FAIL: Code resulted in wrong answer!", "Challenge Result", JOptionPane.ERROR_MESSAGE);
        else {
            JOptionPane.showMessageDialog(this, "SUCCESS: Code resulted in correct answer!", "Challenge Result", JOptionPane.PLAIN_MESSAGE);
            Controller.updateScore(1500);
        }
        dispose();
    }

}
