import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        createGUI();
     /*  //Quizzes quiz = new Quizzes();
       //quiz.createQuiz();
        String jdbcUrl = "jdbc:sqlite:/D:\\A_UWTacoma\\Fall 2021\\TCSS 360\\SQLite\\sqlite-tools-win32-x86-3370000\\sqlite-tools-win32-x86-3370000\\questionsdb.db";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl);
            String sql = "SELECT * FROM question";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String question = result.getString("question");
                String answer_1 = result.getString("answer_1");
                String answer_2 = result.getString("answer_2");
                String answer_3 = result.getString("answer_3");
                String answer_4 = result.getString("answer_4");

                System.out.println(question + "|" + "/n" +answer_1 + "/n" +
                        answer_2 + "/n" + answer_3 + "/n" + answer_4);
            }
        } catch (SQLException e) {
            System.out.print("Error connecting to SQLite database");
            e.printStackTrace();
        }
        */
    }

    public static void createGUI() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 500);
        frame.setResizable(false);
        frame.setTitle("Python Maze Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
       // frame.setLayout(null);
        frame.add(new GUI());


        frame.setVisible(true);
    }
}