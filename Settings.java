import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

/**
 * The settings frame where user can change settings
 *
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */

public class Settings extends JFrame {
    private static final String myBackgroundSettings = "static/images/Settings_background.jpg";
    private static JSlider volume;
    private static JCheckBox mute;

    static URL soundURL = Settings.class.getResource("sound.wav");
    Audio sound = new Audio();

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
        mute = createCheckedSetting(panel, "Muted", 200);
        mute.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (mute.isSelected()) {
                    sound.stop();
                } else {
                    sound.play();
                }
            }
        });
        createCheckedSetting(panel, "Stack Overflow",250);


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
        volume = new JSlider(-20, 6);
        volume.setName("Volume");
        volume.setOpaque(false);
        volume.setBounds(175,150,250,25);
        volume.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sound.currentVolume = volume.getValue();
                if (sound.currentVolume == -20) {
                    sound.currentVolume = -80;
                }
                sound.fc.setValue(sound.currentVolume);
            }
        });
        thePanel.add(volumeLabel);
        thePanel.add(volume);
    }

    /**
     * Creates a checkbox and adds it to the panel passed as a parameter
     *
     * @param thePanel the panel where the volume components should be added
     * @param theTitle the text of the checkbox
     * @param theYPosition where the y position should be
     */
    private JCheckBox createCheckedSetting(final JPanel thePanel, final String theTitle, final int theYPosition){
        JCheckBox checkBox = new JCheckBox("   "+theTitle);
        checkBox.setBounds(40,theYPosition,300,50);
        checkBox.setFocusable(false);
        checkBox.setFont(new Font(Font.DIALOG,  Font.BOLD, 30));
        checkBox.setForeground(Color.white);
        checkBox.setOpaque(false);
        thePanel.add(checkBox);
        return checkBox;
    }

    /**
     * play music background.
     */
    public void playMusic() {
        sound.setFile(soundURL);
        sound.play();
        sound.loop();
    }




}
