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

    /**
     * Constructor
     *
     * @param theQuestion the question
     * @param theOptions the options
     * @param theAnswer which option is correct
     */
    public Question(final String theQuestion, final String[] theOptions, final int theAnswer) {
        myQuestion = theQuestion;
        myOptions = theOptions;
        myAnswer = theAnswer;
    }

    /**
     *
     * @return a String as the question
     */
    public String getMyQuestion() {
        return myQuestion;
    }

    /**
     *
     * @return a string array of the options
     */
    public String[] getMyOptions() {
        return myOptions;
    }

    /**
     *
     * @return an int as the answer
     */
    public int getMyAnswer() {
        return myAnswer;
    }
}
