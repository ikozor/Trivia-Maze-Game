import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private final HashMap<Integer, HashSet<Integer>> myGraph;

    public Graph() {
        myGraph = new HashMap<>();
    }

    public void addVertex(final int theNumber) {
        myGraph.put(theNumber, new HashSet<>());
    }

    public void addEdge(final int theStart, final int theEnd) {
        if (!myGraph.containsKey(theStart))
            myGraph.put(theStart, new HashSet<>());

        if (!myGraph.containsKey(theEnd))
            myGraph.put(theEnd, new HashSet<>());

        myGraph.get(theStart).add(theEnd);
        myGraph.get(theEnd).add(theStart);
    }

    public void removeEdge(final int theStart, final int theEnd) {
        if (!myGraph.containsKey(theStart)) {
            return;
        }

        if (!myGraph.containsKey(theEnd)) {
            return;
        }

        myGraph.get(theStart).remove(theEnd);
        myGraph.get(theEnd).remove(theStart);
    }

    public boolean depthFirstSearch(final int theSource, final int theSize) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[theSize];
        int visits = 0;
        LinkedList<Integer> test = new LinkedList<>();
        stack.add(theSource);
        visited[theSource] = true;


        while (!stack.empty()) {
            int search = stack.pop();
            test.add(search);
            HashSet<Integer> set = myGraph.get(search);
            int[] temp = set.stream().mapToInt(Integer::intValue).toArray();
            for (int i = 0; i < temp.length; i++) {
                if (set.contains(temp[i]) && !visited[temp[i]]) {
                    stack.add(temp[i]);
                    visited[temp[i]] = true;
                    visits++;
                }
            }
        }
        return visits + 1 >= theSize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i : myGraph.keySet()) {
            builder.append(i).append(": ");
            for (int j : myGraph.get(i))
                builder.append(j).append(" ");
            builder.append("\n");
        }
        return (builder.toString());
    }

}
