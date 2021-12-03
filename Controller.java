public class Controller {

<<<<<<< HEAD
    /**
     * Starts a new game
     *
     * @param theName the name as a string for the player
     * @param theDifficulty the difficulty of the game for the player
     */
    public static void startNewGame(final String theName, final Difficulty theDifficulty){
        GameState.newGame(theName,theDifficulty);
        MainFrame.closeFrame();
        new tempCLI();

    }

    /**
     * Loads the saved game
     */
    public static void loadGame(){
        GameState.loadGame();
        MainFrame.closeFrame();
    }

    /**
     * Move the player in the direction
     *
     * @param theDirection where the player should move
     */
=======
    public static void startNewGame(final String theName, final Difficulty theDifficulty){
        GameState.newGame(theName,theDifficulty);
    }

    public static void loadGame(){
        GameState.loadGame();
    }

>>>>>>> rinph
    public static void movePlayer(final Directions theDirection){
        Player.getPlayer().movePlayer(theDirection, true);
    }

<<<<<<< HEAD
    /**
     * Checks if the game is lost
     *
     * @return whether it is possible to finish the game
     */
=======
>>>>>>> rinph
    public static boolean isGameLost(){
        return Player.getPlayer().isMyGameLost();
    }

<<<<<<< HEAD
    /**
     * Quit the current game
     */
=======
>>>>>>> rinph
    public static void quitGame(){
        GameState.endGame();
    }

<<<<<<< HEAD
    /**
     * Save the current game
     */
=======
>>>>>>> rinph
    public static void saveGame(){
        GameState.saveGame();
    }


}
