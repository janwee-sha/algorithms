package graph.test;

import graph.Graph;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GraphTest {
    private Graph graph;

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
        graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
    }

    @Test
    void testNVertex() {
        System.out.println("Testing nVertex method of Graph.");
        assertEquals(6, graph.nVertex());
    }

    @Test
    void testNEdge() {
        System.out.println("Testing nEdge method of Graph.");
        assertEquals(8, graph.nEdge());
        graph.addEdge(4, 5);
        assertEquals(9, graph.nEdge());
        graph.deleteEdge(3, 5);
        assertEquals(8, graph.nEdge());
    }

    @Test
    void testAdj() {
        System.out.println("Testing adj method of Graph.");
        Iterator<Integer> it0 = graph.adj(0).iterator(),
                it1 = graph.adj(1).iterator(), it2 = graph.adj(2).iterator();
        assertEquals(5, it0.next());
        assertEquals(2, it0.next());
        assertEquals(1, it0.next());
        assertFalse(it0.hasNext());
        assertEquals(2, it1.next());
        assertEquals(0, it1.next());
        assertFalse(it1.hasNext());
        assertEquals(3, it2.next());
        assertEquals(4, it2.next());
        assertEquals(1, it2.next());
        assertEquals(0, it2.next());
        assertFalse(it2.hasNext());
    }

    @Test
    void testAddEdge() {
        assertEquals(8, graph.nEdge());
        Iterator<Integer> it = graph.adj(4).iterator();
        assertEquals(3, it.next());
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
        graph.addEdge(4, 5);
        assertEquals(9, graph.nEdge());
        it = graph.adj(4).iterator();
        assertEquals(5, it.next());
        assertEquals(3, it.next());
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testDeleteEdge() {
        assertEquals(8, graph.nEdge());
        Iterator<Integer> it = graph.adj(4).iterator();
        assertEquals(3, it.next());
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
        graph.deleteEdge(3, 4);
        assertEquals(7, graph.nEdge());
        it = graph.adj(4).iterator();
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
    }
}
