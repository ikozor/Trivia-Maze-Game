import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class PythonChallengeFrame extends JFrame {
    public PythonChallengeFrame(){
        this.add(createScreen());
        this.setSize(750, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);

        //REMOVE THIS
    }

    private JPanel createScreen(){

        JPanel panel = new JPanel();
        panel.add(Components.createTitleLabel(50,"CODING CHALLENGE"));
        //panel.add(Components.createLabel(10,200,700,100));

        String[] challenge = Controller.getChallenge();
        String name = challenge[0];
        String challengeText = challenge[2];
        String params = challenge[3];

        JTextArea IDE = createIDE(name,params);

        panel.add(Components.createNewButton("Run",625,390,e ->{
            createFile(IDE.getText());
            dispose();
        }));

        panel.add(createChallengeText(challengeText));

        panel.add(IDE);






        panel.add(Components.createBackground("static/images/Settings_background.jpg",750,500));
        panel.setLayout(null);
        return panel;
    }

    private JTextArea createChallengeText(String theText){
        JTextArea ch = new JTextArea(theText);
        ch.setBounds(50,80,650,50);
        ch.setEditable(false);
        ch.setOpaque(false);
        ch.setFont(new Font(Font.DIALOG,  Font.BOLD, 20));
        ch.setForeground(Color.white);
        ch.setLineWrap(true);
        return ch;
    }

    private JTextArea createIDE(final String theName, final String theParams){
        JTextArea ide = new JTextArea("def " + theName+ "("+theParams+"):\n");
        ide.setBounds(50,135,600,300);
        ide.setFont(new Font(Font.DIALOG,Font.PLAIN, 15));
        ide.setForeground(Color.WHITE);
        ide.setBackground(Color.BLACK);
        return ide;
    }

    private void createFile(final String theCode){
        try {
            FileWriter writer = new FileWriter("python_challenges/Challenge.py");
            writer.write(theCode);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
