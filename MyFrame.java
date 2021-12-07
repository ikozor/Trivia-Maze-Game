import javax.swing.*;

public class MyFrame extends JFrame {

    MyFrame() {
        this.setTitle("Trivia Maze Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.add(new MainScreen());
        this.setVisible(true);
        this.setResizable(false);
    }
}
