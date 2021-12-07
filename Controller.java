public class Controller {
    private static final QuestionManager myQuestionManager = new QuestionManager();
    private static final ChallengeManager myChallengeManager = new ChallengeManager();

    /**
     * Starts a new game
     *
     * @param theName the name as a string for the player
     * @param theDifficulty the difficulty of the game for the player
     */
    public static void startNewGame(final String theName, final Difficulty theDifficulty){
        GameState.newGame(theName,theDifficulty);
        MainFrame.closeFrame();
        MainFrame.goToGame();
    }

    /**
     * Loads the saved game
     */
    public static void loadGame(){
        GameState.loadGame();
    }

    /**
     * Move the player in the direction
     *
     * @param theDirection where the player should move
     */
    public static void movePlayer(final Directions theDirection){
        Player.getPlayer().movePlayer(theDirection, true);
    }

    /**
     * Checks if the game is lost
     *
     * @return whether it is possible to finish the game
     */
    public static boolean isGameLost(){
        return Player.getPlayer().isMyGameLost();
    }

    /**
     * Quit the current game
     */
    public static void quitGame(){
        GameState.endGame();
    }

    /**
     * Save the current game
     */
    public static void saveGame(){
        GameState.saveGame();
    }

    /**
     * Returns a question from the database
     *
     * @return a Question object
     */
    public static Question getQuestion(){
        return myQuestionManager.getNextQuestion();
    }



    public static String[] getChallenge(){
        String[] challenge = myChallengeManager.getChallenge();
        myChallengeManager.nextChallenge();
        return challenge;
    }

    public static int getPlayerDiff(){
        return Player.getPlayer().getLevel().getValue();
    }

    public static boolean getChallengeResult(){
        return myChallengeManager.runScript();
    }
}
