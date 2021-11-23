public enum Difficulty {
    Test(0),
    Easy(1),
    Medium(2),
    Hard(3);

    private int value;
    Difficulty(final int theValue) {
        value = theValue;
    }
    public int getValue(){
        return value;
    }
}
