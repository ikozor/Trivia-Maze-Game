import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;

/**
 * A manager of the questions for the regular maze
 *
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */


public class QuestionManager {
    private Stack<Question> myQuestionStack = new Stack<>();

    /**
     * Creates a stack of questions with the first one always the same when initialized
     */
    public QuestionManager() {
        createStack();
    }

    /**
     * Creates the stack of questions from the database
     */
    private void createStack() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:myquestions.db");
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM questions ORDER BY RANDOM()");
            while (rs.next()) {
                addToQuestionStack(rs.getString("QUESTION"),
                        rs.getString("OPTION1"),
                        rs.getString("OPTION2"),
                        rs.getString("OPTION3"),
                        rs.getString("OPTION4"),
                        rs.getInt("ANSWER"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * sets the first question for a new game
     */
    public void newGameQuestion() {
        String question = "How do you print “Hello World” in Python";
        String[] options = new String[]{"print(“Hello World”);",
                "print(“Hello World”)",
                "printf(“Hello World”)",
                "Shell.Output.print(“Hello World);"};
        int answer = 1;
        myQuestionStack.add(new Question(question, options, answer));
    }

    /**
     * Add a question to the stack based on the parameters
     *
     * @param theQuestion a string of the question to be asked
     * @param theOp1      a string as the first option
     * @param theOp2      a string as the second option
     * @param theOp3      a string as the third option
     * @param theOp4      a string as the fourth option
     * @param theAnswer   an int of which option is the answer
     */
    private void addToQuestionStack(final String theQuestion, final String theOp1, final String theOp2, final String theOp3, final String theOp4, final int theAnswer) {
        String[] options = new String[]{theOp1, theOp2, theOp3, theOp4};
        Question question = new Question(theQuestion, options, theAnswer);
        myQuestionStack.push(question);
    }

    /**
     * pops a question off the stack
     *
     * @return a Question
     */
    public Question getNextQuestion() {
        return myQuestionStack.pop();
    }

    public void reStackQuestions() {
        myQuestionStack = new Stack<>();
        createStack();
    }
}
