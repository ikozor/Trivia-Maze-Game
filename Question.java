public final class Question {
    private final String myQuestion;
    private final String[] myOptions;
    private final int myAnswer;

    public Question(final String theQuestion , final String[] theOptions, final int theAnswer){
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
D:\IntelliJ\IdeaProjects\Trivia Maze\src
