public class Maze {
    private Graph myMaze;
    public Maze(final int theSize){
        myMaze = new Graph();
        createMaze(theSize);
        System.out.println(myMaze.toString());
    }

    private void createMaze(final int theSize){
        int base = (int) Math.sqrt(theSize);
        for(int i = 1;i < theSize+1;i++){
            if(i-3 > 0) myMaze.addEdge(i,i-3);
            if(i-1 > 0) myMaze.addEdge(i,i-1);
            if(i+1 < theSize) myMaze.addEdge(i,i+1);
            if(i+3 < theSize) myMaze.addEdge(i,i+3);
        }

    }
}
