import javax.swing.JFrame;

public class MyFrame extends JFrame {

    MyFrame() {
        this.setTitle("Trivia Maze Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
<<<<<<< HEAD
        this.add(new MainScreen());
=======
        //this.add(new GUI());
>>>>>>> 9952c34a401bd5eb364b122fcc2a9265afcf8da4
        this.setVisible(true);
        this.setResizable(false);
    }
}
