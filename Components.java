import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Components extends JComponent{


    static JLabel createLabel(final int theX, final int theY, final int theWidth, final int theHeight) {
        JLabel label = new JLabel();
        label.setBounds(theX,theY,theWidth,theHeight);
        label.setFocusable(true);
        label.setFont(new Font(Font.DIALOG,  Font.BOLD, 25));
        label.setForeground(Color.YELLOW);
        label.setBackground(Color.BLUE);
        label.setLayout(null);
        label.setVisible(true);
        return label;
    }

    static JTextField createTextField(final int theX, final int theY, final int theWidth, final int theHeight) {
        JTextField textField = new JTextField();
        textField.setBounds(theX, theY, theWidth, theHeight);
        textField.setBackground(Color.CYAN);
        textField.setForeground(Color.BLUE);
        textField.setFont(new Font("Ink Free", Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setVisible(true);
        return  textField;
    }

    static JTextArea createTextArea(final int theX, final int theY, final int theWidth, final int theHeight) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(theX, theY, theWidth, theHeight);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.CYAN);
        textArea.setForeground(Color.BLUE);
        textArea.setFont(new Font("MV Boli", Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setVisible(true);
        return  textArea;
    }

    static JButton createNewButton(final String theName, final int theX, final int theY, final ActionListener theAction){
        JButton button = new JButton(theName);
        button.setBounds(theX,theY,90,42);
        button.setFocusable(false);
        button.addActionListener(theAction);
        button.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        button.setForeground(Color.YELLOW);
        button.setBackground(Color.BLUE);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setLayout(null);
        button.setVisible(true);
        return button;
    }

    static JButton createAnswerButton(final String theName, final int theX, final int theY, final ActionListener theAction) {
        JButton answer = new JButton(theName);
        answer.setBounds(theX,theY,75,42);
        answer.setFocusable(false);
        answer.addActionListener(theAction);
        answer.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        answer.setForeground(Color.blue);
        answer.setBackground(Color.cyan);
        answer.setBorder(BorderFactory.createEtchedBorder());
        answer.setLayout(null);
        answer.setVisible(true);
        return answer;
    }

    static JLabel createAnswerLabel(final int theX, final int theY, final int theWidth, final int theHeight) {
        JLabel answerLabel = new JLabel();
        answerLabel.setBounds(theX,theY,theWidth,theHeight);
        answerLabel.setFocusable(true);
        answerLabel.setFont(new Font(Font.DIALOG,  Font.BOLD, 15));
        answerLabel.setForeground(Color.YELLOW);
        answerLabel.setBackground(Color.BLUE);
        answerLabel.setLayout(null);
        answerLabel.setVisible(true);
        return answerLabel;

    }

    /**
     * Creates the Background for the title page\
     *
     * @return A JLabel as the background
     */
    public static JLabel createBackground(final String theLocation, final int theWidth, final int theHeight){
        JLabel background = new JLabel();
        ImageIcon imageIcon = new ImageIcon(theLocation);
        Image image = imageIcon.getImage().getScaledInstance(theWidth,theHeight, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(image);
        background.setIcon(imageIcon);
        background.setBounds(0,0,theWidth, theHeight);
        return background;
    }

    /**
     * Creates the Title for the Title Page
     *
     * @return a JLabel for the Title
     */
    static JLabel createTitleLabel(final String theTitle){
        JLabel label = new JLabel(theTitle);
        label.setFont(new Font(Font.DIALOG,  Font.BOLD, 60));
        label.setBounds(200,10,700,70);
        label.setForeground(Color.WHITE);
        return label;
    }

    /**
     * Creates a new Button based on the parameters
     *
     * @param theName as the text of the button
     * @param theXPosition the y position of the button
     * @param theYPosition the y position of the button
     * @param theAction what the button is supposed to do
     *
     * @return a new JButton
     */
    static JButton createMenuButton(final String theName, final int theXPosition, final int theYPosition, final ActionListener theAction){
        JButton button = new JButton(theName);
        button.setBounds(theXPosition,theYPosition,200,50);
        button.setFocusable(false);
        button.addActionListener(theAction);
        button.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLUE);
        button.setBorder(BorderFactory.createEtchedBorder());
        return(button);
    }}
