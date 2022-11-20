package LinkedList.test;

import LinkedList.ListNode;
import LinkedList.RemoveElements;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RemoveElementsTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting RemoveElementsTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finished RemoveElementsTest.");
    }

    private void testSolution(RemoveElements.Solution solution) {
        ListNode node0 = null;
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);

        ListNode node5 = new ListNode(5),
                node6 = new ListNode(5, node5),
                node7 = new ListNode(5, node6),
                node8 = new ListNode(5, node7);

        assertNull(solution.removeElements(node0, 0));
        ListNode node = solution.removeElements(node4, 2);
        assertEquals(4, node.val);
        assertEquals(3, node.next.val);
        assertEquals(1, node.next.next.val);
        assertNull(solution.removeElements(node8, 5));
    }

    @Test
    public void testSolution1() {
        System.out.println("Testing solution 1.");
        RemoveElements.Solution s = new RemoveElements.Solution1();
        testSolution(s);
    }

    @Test
    public void testSolution2() {
        System.out.println("Testing solution 2.");
        RemoveElements.Solution s = new RemoveElements.Solution2();
        testSolution(s);
    }
}
