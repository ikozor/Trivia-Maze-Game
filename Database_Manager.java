import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;


public class Database_Manager {
    private Stack<Question> myQuestionStack = new Stack<>();


    public Database_Manager(){
        createStack();
        String question = "How do you print “Hello World” in Python";
        String[] options = new String[]{"print(“Hello World”);",
                "print(“Hello World”)",
                "printf(“Hello World”)",
                "Shell.Output.print(“Hello World);"};
        int answer = 1;
        myQuestionStack.add(new Question(question,options,answer));
    }

    private void createStack(){
       Connection con = null;
       try {
           con = DriverManager.getConnection("jdbc:sqlite:myquestions.db");
           Statement statement = con.createStatement();

           ResultSet rs = statement.executeQuery("SELECT * FROM questions ORDER BY RANDOM()");
           while(rs.next())
           {
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

    private void addToQuestionStack(final String theQuestion,final String theOp1, final String theOp2, final String theOp3, final String theOp4, final int theAnswer){
        String[] options = new String[]{theOp1,theOp2,theOp3,theOp4};
        Question question = new Question(theQuestion,options, theAnswer);
        myQuestionStack.push(question);
    }

    public Question getNextQuestion(){
        return myQuestionStack.pop();
    }
}
