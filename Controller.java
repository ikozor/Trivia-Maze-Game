/**
 * Controls flow of information and inputs from Model to View
 *
 * @author Ilya Kozorezov
 * @author Rin Pham
 * @version 1.0
 * @since 1.0
 */

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
        MainFrame.goTo(new MainScreen());
    }

    /**
     * Loads the saved game
     */
    public static void loadGame(){
        GameState.loadGame();
        MainFrame.closeFrame();
        MainFrame.goTo(new MainMenu());
    }

    /**
     * Move the player in the direction
     *
     * @param theDirection where the player should move
     */
    public static void movePlayer(final Directions theDirection){
        Player.getPlayer().movePlayer(theDirection, true);
    }

    public static void askQuestion(){

    }

    public static boolean getQuestionResult(){
        return false;
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
     * Get the level of difficulty
     */
    public static int getLevelDifficulty() {
       return GameState.getLevelDiff();

    }
    /**
     * Get player position
     */
    public static int getPlayerPos(){
        return Player.getPlayer().getPlayerPosition();
    }

    /**
     * Returns a question from the database
     *
     * @return a Question object
     */

    public static Question getQuestion(){
        return myQuestionManager.getNextQuestion();
    }

    /**
     * Returns the current challenge as a String array
     *
     * @return a String array as the challenge
     */
    public static String[] getChallenge(){
        myChallengeManager.nextChallenge();
        return myChallengeManager.getChallenge();
    }

    /**
     * Returns the result of the challenge after the python file is run
     *
     * @return boolean if the challenge was a success
     */
    public static boolean getChallengeResult(){
        return myChallengeManager.runScript();
    }
}
