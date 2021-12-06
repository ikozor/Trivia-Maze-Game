import java.io.*;
import java.sql.*;
import java.util.Objects;

public class ChallengeManager {
    String myName;
    String myAnswer;
    String myChallenge;
    String myParams;

    public ChallengeManager(){
        nextChallenge();
    }

    public void nextChallenge(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:sqlite:myquestions.db");
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM challenges ORDER BY RANDOM() LIMIT 1");
            myName = rs.getString("Name");
            myAnswer = rs.getString("Answer");
            myChallenge = rs.getString("Challenge");
            myParams = rs.getString("Params");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public boolean runScript(){
        try {
            ProcessBuilder pb = new ProcessBuilder("python","python_challenges/CheckChallenge.py");
            Process p = pb.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String result = in.readLine();

            return Objects.equals(result, myAnswer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String[] getChallenge(){
        return new String[]{myName,myAnswer,myChallenge,myParams};
    }
}
