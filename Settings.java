import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

/**
 * The settings frame where user can change settings
 *
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */

public class Settings extends JFrame {
    private static final String myBackgroundSettings = "static/images/Settings_background.jpg";

    /**
     * Creates a new settings frame
     */
    public Settings(){
        this.add(createSettingPanel());


        this.setSize(500, 500);
        this.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);

    }
    /**
     * Creates a new settings panel
     */
    private JPanel createSettingPanel(){
        JPanel panel = new JPanel();
        panel.add(Components.createTitleLabel(100,"Settings"));
        createVolume(panel);
        createCheckedSetting("Muted", 200);


        JCheckBox cheats = createCheckedSetting("Stack Overflow",250);
        cheats.setSelected(Controller.cheatsAllowed());
        cheats.addActionListener(e ->{
            Controller.allowCheats(cheats.isSelected());
        });
        this.add(cheats);


        panel.add(Components.createBackground(myBackgroundSettings,500,500));
        panel.setLayout(null);
        return panel;

    }

    /**
     * Creates the Volume components for the panel passed as the parameter
     *
     * @param thePanel the panel where the volume components should be added
     */
    private void createVolume(final JPanel thePanel){
        JLabel volumeLabel = new JLabel("Volume");
        volumeLabel.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        volumeLabel.setBounds(40,150,150,25);
        volumeLabel.setForeground(Color.white);
        JSlider volume = new JSlider(0,0,100,100);
        volume.setName("Volume");
        volume.setOpaque(false);
        volume.setBounds(175,150,250,25);
        thePanel.add(volumeLabel);
        thePanel.add(volume);
    }

    /**
     * Creates a checkbox and adds it to the panel passed as a parameter
     *
     * @param theTitle the text of the checkbox
     * @param theYPosition where the y position should be
     */
    private JCheckBox createCheckedSetting(final String theTitle, final int theYPosition){
        JCheckBox checkBox = new JCheckBox("   "+theTitle);
        checkBox.setBounds(40,theYPosition,300,50);
        checkBox.setFocusable(false);
        checkBox.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        checkBox.setForeground(Color.white);
        checkBox.setOpaque(false);
        return checkBox;
    }


}
