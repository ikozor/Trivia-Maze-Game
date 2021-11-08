import java.util.HashMap;
import java.util.HashSet;
import java.util.NoSuchElementException;

public class Graph {
    private HashMap<Integer , HashSet<Integer>> myGraph;

    public Graph(){
        myGraph = new HashMap<>();
    }

    public void addVertex(final int theNumber){
        myGraph.put(theNumber, new HashSet<>());
    }

    public void addEdge(final int theStart, final int theEnd){
        if(!myGraph.containsKey(theStart))
            myGraph.put(theStart, new HashSet<>());

        if(!myGraph.containsKey(theEnd))
            myGraph.put(theEnd, new HashSet<>());

        myGraph.get(theStart).add(theEnd);
        myGraph.get(theEnd).add(theStart);
    }

    public void removeEdge(final int theStart, final int theEnd){
        if(!myGraph.containsKey(theStart)) {
            System.out.println("Graph:\nTHE (start to) EDGE TO BE DELETED DOES NOT EXIST");
            return;
        }

        if(!myGraph.containsKey(theEnd)) {
            System.out.println("Graph:\nTHE (end to) EDGE TO BE DELETED DOES NOT EXIST");
            return;
        }

        myGraph.get(theStart).remove(theEnd);
        myGraph.get(theEnd).remove(theStart);
    }

    public boolean hasEdge(final int theStart, final int theEnd){
        return myGraph.containsKey(theStart) && myGraph.get(theStart).contains(theEnd);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i : myGraph.keySet()){
            builder.append(i).append(": ");
            for(int j : myGraph.get(i))
                builder.append(j).append(" ");
            builder.append("\n");
        }
        return (builder.toString());
    }

}
