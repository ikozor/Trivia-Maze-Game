public class Maze {

    private final int SIZE;
    private final Graph myMaze;
    private final Question test = new Question("test", new String[]{"1"}, 0);

    public Maze(final int theSize) {
        SIZE = theSize;
        myMaze = new Graph();
        createMaze(theSize);
    }

    private void createMaze(final int theSize) {
        int base = (int) Math.sqrt(theSize);

        for (int i = 0; i < theSize; i++) {
            if (i + base < theSize) myMaze.addEdge(i, i + base);
            if (i - base >= 0) myMaze.addEdge(i, i - base);
            for (int j = i + 1; j < base + i - 1; j++) {
                if (j - base >= 0) myMaze.addEdge(j, j - base);
                if (j - 1 >= 0) myMaze.addEdge(j, j - 1);
                if (j + 1 < theSize) myMaze.addEdge(j, j + 1);
                if (j + base < theSize) myMaze.addEdge(j, j + base);
            }
            i += base - 1;
            if (i + base < theSize) myMaze.addEdge(i, i + base);
            if (i - base >= 0) myMaze.addEdge(i, i - base);


        }
    }

    public boolean closeDoor(final int theFrom, final int theWhere) {
        myMaze.removeEdge(theFrom, theWhere);
        return myMaze.depthFirstSearch(theFrom, SIZE);
    }


    @Override
    public String toString() {
        return myMaze.toString();
    }
}
