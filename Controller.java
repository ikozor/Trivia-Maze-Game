public class Controller {

    public static void startNewGame(final String theName, final Difficulty theDifficulty){
        GameState.newGame(theName,theDifficulty);
    }

    public static void loadGame(){
        GameState.loadGame();
    }

    public static void movePlayer(final Directions theDirection){
        Player.getPlayer().movePlayer(theDirection, true);
    }

    public static boolean isGameLost(){
        return Player.getPlayer().isMyGameLost();
    }

    public static void quitGame(){
        GameState.endGame();
    }

    public static void saveGame(){
        GameState.saveGame();
    }


}
