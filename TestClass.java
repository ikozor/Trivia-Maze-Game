import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestClass {

    @Test
    void testAddVertex_on_BlankGraph() {
        Graph graph = new Graph();
        graph.addVertex(1);
        assertEquals(graph.toString(), "1: \n");
    }

    @Test
    void testAddVertex_on_UsedGraph() {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        assertEquals(graph.toString(), "1: \n" +
                "2: \n");
    }

    @Test
    void testAddVertex_duplicateVertexes() {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(1);
        assertEquals(graph.toString(), "1: \n");
    }

    @Test
    void testAddEdge_on_BlankGraph() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        assertEquals(graph.toString(), "1: 2 \n" +
                "2: 1 \n");
    }

    @Test
    void testAddEdge_on_UsedGraph() {
        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2);
        assertEquals(graph.toString(), "1: 2 \n" +
                "2: 1 \n");
    }

    @Test
    void testAddEdge_duplicateEdges() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 2);
        assertEquals(graph.toString(), "1: 2 \n" +
                "2: 1 \n");
    }

    @Test
    void testRemoveEdge() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.removeEdge(1, 2);
        assertEquals(graph.toString(), "1: \n" +
                "2: \n");
    }

    @Test
    void testRemoveEdge_thatDoesNotExist() {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.removeEdge(1, 2);
        graph.removeEdge(1, 2);
        assertEquals(graph.toString(), "1: \n" +
                "2: \n");
    }

    @Test
    void testDepthFirstSearch_onConnectedGraph() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        assertTrue(graph.depthFirstSearch(0, 4));
    }

    @Test
    void testDepthFirstSearch_onUnconnectedGraph() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        assertFalse(graph.depthFirstSearch(0, 4));
    }

    @Test
    void testCreate4x4_Maze() {
        Maze maze = new Maze(16);
        assertEquals(maze.toString(), "0: 1 4 \n" +
                "1: 0 2 5 \n" +
                "2: 1 3 6 \n" +
                "3: 2 7 \n" +
                "4: 0 5 8 \n" +
                "5: 1 4 6 9 \n" +
                "6: 2 5 7 10 \n" +
                "7: 3 6 11 \n" +
                "8: 4 9 12 \n" +
                "9: 5 8 10 13 \n" +
                "10: 6 9 11 14 \n" +
                "11: 7 10 15 \n" +
                "12: 8 13 \n" +
                "13: 9 12 14 \n" +
                "14: 10 13 15 \n" +
                "15: 11 14 \n");
    }

    @Test
    void testCreate5x5_Maze() {
        Maze maze = new Maze(25);
        assertEquals(maze.toString(), "0: 1 5 \n" +
                "1: 0 2 6 \n" +
                "2: 1 3 7 \n" +
                "3: 2 4 8 \n" +
                "4: 3 9 \n" +
                "5: 0 6 10 \n" +
                "6: 1 5 7 11 \n" +
                "7: 2 6 8 12 \n" +
                "8: 3 7 9 13 \n" +
                "9: 4 8 14 \n" +
                "10: 5 11 15 \n" +
                "11: 16 6 10 12 \n" +
                "12: 17 7 11 13 \n" +
                "13: 18 8 12 14 \n" +
                "14: 19 9 13 \n" +
                "15: 16 20 10 \n" +
                "16: 17 21 11 15 \n" +
                "17: 16 18 22 12 \n" +
                "18: 17 19 23 13 \n" +
                "19: 18 24 14 \n" +
                "20: 21 15 \n" +
                "21: 16 20 22 \n" +
                "22: 17 21 23 \n" +
                "23: 18 22 24 \n" +
                "24: 19 23 \n");
    }

    @Test
    void testCreate6x6_Maze() {
        Maze maze = new Maze(36);
        assertEquals(maze.toString(), "0: 1 6 \n" +
                "1: 0 2 7 \n" +
                "2: 1 3 8 \n" +
                "3: 2 4 9 \n" +
                "4: 3 5 10 \n" +
                "5: 4 11 \n" +
                "6: 0 7 12 \n" +
                "7: 1 6 8 13 \n" +
                "8: 2 7 9 14 \n" +
                "9: 3 8 10 15 \n" +
                "10: 16 4 9 11 \n" +
                "11: 17 5 10 \n" +
                "12: 18 6 13 \n" +
                "13: 19 7 12 14 \n" +
                "14: 20 8 13 15 \n" +
                "15: 16 21 9 14 \n" +
                "16: 17 22 10 15 \n" +
                "17: 16 23 11 \n" +
                "18: 19 24 12 \n" +
                "19: 18 20 25 13 \n" +
                "20: 19 21 26 14 \n" +
                "21: 20 22 27 15 \n" +
                "22: 16 21 23 28 \n" +
                "23: 17 22 29 \n" +
                "24: 18 25 30 \n" +
                "25: 19 24 26 31 \n" +
                "26: 32 20 25 27 \n" +
                "27: 33 21 26 28 \n" +
                "28: 34 22 27 29 \n" +
                "29: 35 23 28 \n" +
                "30: 24 31 \n" +
                "31: 32 25 30 \n" +
                "32: 33 26 31 \n" +
                "33: 32 34 27 \n" +
                "34: 33 35 28 \n" +
                "35: 34 29 \n");
    }

    @Test
    void testCloseDoor() {
        Maze maze = new Maze(9);
        maze.closeDoor(1, 2);
        assertEquals(maze.toString(), "0: 1 3 \n" +
                "1: 0 4 \n" +
                "2: 5 \n" +
                "3: 0 4 6 \n" +
                "4: 1 3 5 7 \n" +
                "5: 2 4 8 \n" +
                "6: 3 7 \n" +
                "7: 4 6 8 \n" +
                "8: 5 7 \n");
    }

    @Test
    void testCloseDoor_AlreadyClosed() {
        Maze maze = new Maze(9);
        maze.closeDoor(1, 2);
        maze.closeDoor(1, 2);
        assertEquals(maze.toString(), "0: 1 3 \n" +
                "1: 0 4 \n" +
                "2: 5 \n" +
                "3: 0 4 6 \n" +
                "4: 1 3 5 7 \n" +
                "5: 2 4 8 \n" +
                "6: 3 7 \n" +
                "7: 4 6 8 \n" +
                "8: 5 7 \n");
    }

    @Test
    void testCloseDoor_mazeStillConnected() {
        Maze maze = new Maze(9);
        assertTrue(maze.closeDoor(0, 1));
    }

    @Test
    void testCloseDoor_mazeNowUnconnected() {
        Maze maze = new Maze(9);
        maze.closeDoor(0, 3);
        assertFalse(maze.closeDoor(0, 1));
    }
}