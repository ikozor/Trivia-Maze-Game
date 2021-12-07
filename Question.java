import java.io.Serializable;

/**
 * Data class as the question
 *
 * @author Ilya Kozorezov
 * @version 1.0
 * @since 1.0
 */

public final class Question  implements Serializable {
    private final String myQuestion;
    private final String[] myOptions;
    private final int myAnswer;

    public Question(final String theQuestion, final String[] theOptions, final int theAnswer) {
        myQuestion = theQuestion;
        myOptions = theOptions;
        myAnswer = theAnswer;
    }

    public String getMyQuestion() {
        return myQuestion;
    }

    public String[] getMyOptions() {
        return myOptions;
    }

    public int getMyAnswer() {
        return myAnswer;
    }
}
