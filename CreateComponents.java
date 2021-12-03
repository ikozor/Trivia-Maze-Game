import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateComponents {

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
    static JButton createButton(final String theName, final int theXPosition, final int theYPosition, final ActionListener theAction){
        JButton button = new JButton(theName);
        button.setBounds(theXPosition,theYPosition,200,50);
        button.setFocusable(false);
        button.addActionListener(theAction);
        button.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLUE);
        button.setBorder(BorderFactory.createEtchedBorder());
        return(button);
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
        background.setBounds(0,0,1000, 500);
        return background;
    }
}
