import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Components extends JComponent{

    static JLabel createLabel(final String theName, final int theX, final int theY, final int theWidth, final int theHeight) {
        JLabel label = new JLabel(theName);
        label.setBounds(theX,theY,theWidth,theHeight);
        label.setFocusable(true);
        label.setFont(new Font(Font.DIALOG,  Font.BOLD, 25));
        label.setForeground(Color.YELLOW);
        label.setBackground(Color.BLUE);
        label.setLayout(null);
        label.setVisible(true);
        return label;
    }

    static JButton createNewButton(final String theName, final int theX, final int theY, final ActionListener theAction){
        JButton button = new JButton(theName);
        button.setBounds(theX,theY,100,42);
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

    static JTextField createTextField() {
        JTextField textField = new JTextField();
        return  textField;
    }

}
