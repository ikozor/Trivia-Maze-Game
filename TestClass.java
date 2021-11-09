import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestClass {

    @Test
    void test_addVertex_on_BlankGraph(){
        Graph graph = new Graph();
        graph.addVertex(1);
        assertEquals(graph.toString(), "1: \n");
    }

    @Test
    void test_addVertex_on_UsedGraph(){
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        assertEquals(graph.toString(),"1: \n" +
                                            "2: \n");
    }

    @Test
    void test_addVertex_duplicateVertexes(){
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(1);
        assertEquals(graph.toString(),"1: \n");
    }

    @Test
    void test_addEdge_on_BlankGraph(){
        Graph graph = new Graph();
        graph.addEdge(1,2);
        assertEquals(graph.toString(),"1: 2 \n" +
                                            "2: 1 \n");
    }

    @Test
    void test_addEdge_on_UsedGraph(){
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1,2);
        assertEquals(graph.toString(),"1: 2 \n" +
                                            "2: 1 \n");
    }

    @Test
    void test_addEdge_duplicateEdges(){
        Graph graph = new Graph();
        graph.addEdge(1,2);
        graph.addEdge(1,2);
        assertEquals(graph.toString(),"1: 2 \n" +
                "2: 1 \n");
    }

    @Test
    void test_removeEdge(){
        Graph graph = new Graph();
        graph.addEdge(1,2);
        graph.removeEdge(1,2);
        assertEquals(graph.toString(),"1: \n" +
                                            "2: \n");
    }

    @Test
    void test_removeEdge_thatDoesNotExist(){
        Graph graph = new Graph();
        graph.addEdge(1,2);
        graph.removeEdge(1,2);
        graph.removeEdge(1,2);
        assertEquals(graph.toString(),"1: \n" +
                "2: \n");
    }

    @Test
    void testCreate4x4_Maze(){
        Maze maze = new Maze(16);
        assertEquals(maze.toString(), "1: 2 5 \n" +
                                            "2: 1 3 6 \n" +
                                            "3: 2 4 7 \n" +
                                            "4: 3 8 \n" +
                                            "5: 1 6 9 \n" +
                                            "6: 2 5 7 10 \n" +
                                            "7: 3 6 8 11 \n" +
                                            "8: 4 7 12 \n" +
                                            "9: 5 10 13 \n" +
                                            "10: 6 9 11 14 \n" +
                                            "11: 7 10 12 15 \n" +
                                            "12: 16 8 11 \n" +
                                            "13: 9 14 \n" +
                                            "14: 10 13 15 \n" +
                                            "15: 16 11 14 \n" +
                                            "16: 12 15 \n");
    }

    @Test
    void testCreate5x5_Maze() {
        Maze maze = new Maze(25);
        assertEquals(maze.toString(), "1: 2 6 \n" +
                                            "2: 1 3 7 \n" +
                                            "3: 2 4 8 \n" +
                                            "4: 3 5 9 \n" +
                                            "5: 4 10 \n" +
                                            "6: 1 7 11 \n" +
                                            "7: 2 6 8 12 \n" +
                                            "8: 3 7 9 13 \n" +
                                            "9: 4 8 10 14 \n" +
                                            "10: 5 9 15 \n" +
                                            "11: 16 6 12 \n" +
                                            "12: 17 7 11 13 \n" +
                                            "13: 18 8 12 14 \n" +
                                            "14: 19 9 13 15 \n" +
                                            "15: 20 10 14 \n" +
                                            "16: 17 21 11 \n" +
                                            "17: 16 18 22 12 \n" +
                                            "18: 17 19 23 13 \n" +
                                            "19: 18 20 24 14 \n" +
                                            "20: 19 25 15 \n" +
                                            "21: 16 22 \n" +
                                            "22: 17 21 23 \n" +
                                            "23: 18 22 24 \n" +
                                            "24: 19 23 25 \n" +
                                            "25: 20 24 \n");
    }

    @Test
    void testCreate6x6_Maze(){
        Maze maze = new Maze(36);
        assertEquals(maze.toString(), "1: 2 7 \n" +
                                            "2: 1 3 8 \n" +
                                            "3: 2 4 9 \n" +
                                            "4: 3 5 10 \n" +
                                            "5: 4 6 11 \n" +
                                            "6: 5 12 \n" +
                                            "7: 1 8 13 \n" +
                                            "8: 2 7 9 14 \n" +
                                            "9: 3 8 10 15 \n" +
                                            "10: 16 4 9 11 \n" +
                                            "11: 17 5 10 12 \n" +
                                            "12: 18 6 11 \n" +
                                            "13: 19 7 14 \n" +
                                            "14: 20 8 13 15 \n" +
                                            "15: 16 21 9 14 \n" +
                                            "16: 17 22 10 15 \n" +
                                            "17: 16 18 23 11 \n" +
                                            "18: 17 24 12 \n" +
                                            "19: 20 25 13 \n" +
                                            "20: 19 21 26 14 \n" +
                                            "21: 20 22 27 15 \n" +
                                            "22: 16 21 23 28 \n" +
                                            "23: 17 22 24 29 \n" +
                                            "24: 18 23 30 \n" +
                                            "25: 19 26 31 \n" +
                                            "26: 32 20 25 27 \n" +
                                            "27: 33 21 26 28 \n" +
                                            "28: 34 22 27 29 \n" +
                                            "29: 35 23 28 30 \n" +
                                            "30: 36 24 29 \n" +
                                            "31: 32 25 \n" +
                                            "32: 33 26 31 \n" +
                                            "33: 32 34 27 \n" +
                                            "34: 33 35 28 \n" +
                                            "35: 34 36 29 \n" +
                                            "36: 35 30 \n");
    }

    @Test
    void test_closeDoor(){
        Maze maze = new Maze(9);
        maze.closeDoor(1,2);
        assertEquals(maze.toString(), "1: 4 \n" +
                                            "2: 3 5 \n" +
                                            "3: 2 6 \n" +
                                            "4: 1 5 7 \n" +
                                            "5: 2 4 6 8 \n" +
                                            "6: 3 5 9 \n" +
                                            "7: 4 8 \n" +
                                            "8: 5 7 9 \n" +
                                            "9: 6 8 \n");
    }

    @Test
    void test_closeDoor_AlreadyClosed(){
        Maze maze = new Maze(9);
        maze.closeDoor(1,2);
        maze.closeDoor(1,2);
        assertEquals(maze.toString(), "1: 4 \n" +
                "2: 3 5 \n" +
                "3: 2 6 \n" +
                "4: 1 5 7 \n" +
                "5: 2 4 6 8 \n" +
                "6: 3 5 9 \n" +
                "7: 4 8 \n" +
                "8: 5 7 9 \n" +
                "9: 6 8 \n");
    }
}