package LinkedList.test;

import LinkedList.FindCycleEntrance;
import LinkedList.ListNode;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FindCycleEntranceTest {
    private ListNode node1, node2, node3, node4, node5, node6, node7;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting FindCycleEntranceTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished FindCycleEntranceTest.");
    }

    @BeforeEach
    public void initialize() {
        System.out.println("Setting up instances of ListNode");
        node1 = new ListNode(1);
        node2 = new ListNode(2, node1);
        node3 = new ListNode(3, node2);
        node4 = new ListNode(4, node3);
        node5 = new ListNode(5, node4);
        node1.next = node4;
        node6 = new ListNode(6);
        node7 = null;
    }

    @Test
    public void testSolution1() {
        System.out.println("Testing solution 1...");

        FindCycleEntrance.Solution1 solution1 = new FindCycleEntrance.Solution1();

        assertEquals(node4, solution1.findCycleEntrance(node5));
        assertNull(solution1.findCycleEntrance(node6));
        assertNull(solution1.findCycleEntrance(node7));
    }

    @Test
    public void testSolution2() {
        System.out.println("Testing solution 2...");

        FindCycleEntrance.Solution2 solution2 = new FindCycleEntrance.Solution2();

        assertEquals(node4, solution2.findCycleEntrance(node5));
        assertNull(solution2.findCycleEntrance(node6));
        assertNull(solution2.findCycleEntrance(node7));
    }
}
