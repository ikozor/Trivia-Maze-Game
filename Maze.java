public class Maze {

    private Graph myMaze;
    private int myPlayerPosition;

    private Question test = new Question("test",new String[]{"1"},0);

    public Maze(final int theSize){
        myMaze = new Graph();
        createMaze(theSize);
        myPlayerPosition = 1;
    }

    private void createMaze(final int theSize){
        int base = (int) Math.sqrt(theSize);

        for(int i = 1;i < theSize+1;i++){
            if(i+base < theSize+1) myMaze.addEdge(i,i+base);
            if(i-base > 0) myMaze.addEdge(i,i-base);
            for (int j = i+1; j < base+i-1; j++) {
                if(j-base > 0) myMaze.addEdge(j,j-base);
                if(j-1 > 0) myMaze.addEdge(j,j-1);
                if(j+1 < theSize+1) myMaze.addEdge(j,j+1);
                if(j+base < theSize+1) myMaze.addEdge(j,j+base);
            }

            i += base-1;
            if(i+base < theSize+1) myMaze.addEdge(i,i+base);
            if(i-base > 0) myMaze.addEdge(i,i-base);
        }
    }

    public void closeDoor(final int theFrom , final int theWhere){
        myMaze.removeEdge(theFrom,theWhere);
    }



    @Override
    public String toString(){
        return myMaze.toString();
    }
}
