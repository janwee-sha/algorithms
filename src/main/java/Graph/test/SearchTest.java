package Graph.test;

import Graph.BreadthFirstSearch;
import Graph.DepthFirstSearch;
import Graph.Graph;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {
    private Graph graph;
    private DepthFirstSearch depthFirst;
    private BreadthFirstSearch breadthFirst;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting GraphTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished GraphTest.");
    }

    @BeforeEach
    void initialize() {
        System.out.println("Setting up instance of Graph.");
        graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        depthFirst = new DepthFirstSearch(graph, 0);
        breadthFirst = new BreadthFirstSearch(graph, 0);
    }

    @Test
    void testHasPathTo() {
        System.out.println("Testing hasPathTo method.");
        assertTrue(depthFirst.hasPathTo(1));
        assertTrue(depthFirst.hasPathTo(3));
        assertTrue(depthFirst.hasPathTo(5));
        assertFalse(depthFirst.hasPathTo(6));
    }

    @Test
    void testDepthFirstPathTo() {
        //result of pathTo method depends on the both structure and expression
        //of the graph
        System.out.println("Testing pathTo method of DepthFirstGraphPaths.");
        Stack<Integer> stack = depthFirst.pathTo(4);
        assertEquals(0, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    void testBreadthFirstPathTo() {
        System.out.println("Testing pathTo method of BreadthFirstGraphPaths.");
        Stack<Integer> stack = breadthFirst.pathTo(4);
        assertEquals(0, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(4, stack.pop());
        assertTrue(stack.empty());
    }
}
