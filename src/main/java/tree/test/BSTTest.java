package tree.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.BST;
import tree.Tree;
import tree.RBBST;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BSTTest {
    private BST<Integer, Integer> node1;
    private Tree<Integer, Integer> node2;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting BSTNodeTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished BSTNodeTest.");
    }

    @BeforeEach
    public void initialize() {
        System.out.println("Setting up instance of BSTNode.");

        node1 = new BST<>();
        node1.put(5, 50);
        node1.put(2, 20);
        node1.put(10, 100);
        node1.put(9, 90);
        node1.put(-5, -50);
        node1.put(7, 70);

        node2 = new RBBST<>();
        node2.put(5, 50);
        node2.put(2, 20);
        node2.put(10, 100);
        node2.put(9, 90);
        node2.put(-5, -50);
        node2.put(7, 70);
    }

    private void testGet(Tree<Integer, Integer> node) {
        assertNull(node.get(6));
        assertEquals(50, node.get(5));
        assertEquals(20, node.get(2));
        assertEquals(100, node.get(10));
        assertEquals(90, node.get(9));
        assertEquals(-50, node.get(-5));
        assertEquals(70, node.get(7));
    }

    private void testPut(Tree<Integer, Integer> node) {
        assertNull(node.get(6));
        node.put(6, 60);
        assertEquals(60, node.get(6));
        assertEquals(50, node.get(5));
        assertEquals(20, node.get(2));
        assertEquals(100, node.get(10));
        assertEquals(90, node.get(9));
        assertEquals(-50, node.get(-5));
        assertEquals(70, node.get(7));

        assertEquals(20, node.get(2));
        node.put(2, -1);
        assertEquals(-1, node.get(2));
        assertEquals(50, node.get(5));
        assertEquals(100, node.get(10));
        assertEquals(90, node.get(9));
        assertEquals(-50, node.get(-5));
        assertEquals(70, node.get(7));
    }


    @Test
    public void testBSTNodeGet() {
        System.out.println("Testing BSTNode get.");
        testGet(node1);
    }

    @Test
    public void testBSTNodePut() {
        System.out.println("Testing BSTNode put.");
        testPut(node1);
    }

    @Test
    public void testRBBSTNodeGet() {
        System.out.println("Testing RBBSTNode get.");
        testGet(node2);
    }

    @Test
    public void testRBBSTNodePut() {
        System.out.println("Testing RBBSTNode put.");
        testPut(node2);
    }

    @Test
    public void testBSTMin() {
        System.out.println("Testing BinarySearchTree min.");
        assertEquals(-5, node1.min());
    }

    @Test
    public void testBSTMax() {
        System.out.println("Testing BinarySearchTree min.");
        assertEquals(10, node1.max());
    }
}
