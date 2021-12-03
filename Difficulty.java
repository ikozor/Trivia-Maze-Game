<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;

=======
>>>>>>> rinph
public enum Difficulty {
    Test(0),
    Easy(1),
    Medium(2),
    Hard(3);

    private int value;
<<<<<<< HEAD

    /**
     * Links a value to the enum value
     * @param theValue passed to the enum value
     */
=======
>>>>>>> rinph
    Difficulty(final int theValue) {
        value = theValue;
    }
    public int getValue(){
        return value;
    }
<<<<<<< HEAD

    /**
     * Creates a map with the int number value for each enum
     */
    private static Map<Integer, Difficulty> map = new HashMap<Integer, Difficulty>();
    static {
        for (Difficulty difficulty : Difficulty.values()){
            map.put(difficulty.value, difficulty);
        }
    }

    /**
     *
     * @param theIndex the int value of the enum
     * @return the enum at the int value
     */
    public static Difficulty valueOf(final int theIndex) {
        return map.get(theIndex);
    }
=======
>>>>>>> rinph
}
