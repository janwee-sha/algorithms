package linkedlist.test;

import linkedlist.Bag;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
    private Bag<Integer> bag1, bag2;
    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting BagTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished BagTest.");
    }

    @BeforeEach
    void initialize() {
        System.out.println("Setting up instances of Bag.");
        bag1 = new Bag<>();
        bag2 = new Bag<>();
        bag2.add(3);
        bag2.add(2);
        bag2.add(1);
    }

    @Test
    void testAddAndIterator() {
        System.out.println("Testing add and iterator.");

        assertFalse(bag1.iterator().hasNext());
        bag1.add(0);
        assertTrue(bag1.iterator().hasNext());
        assertEquals(0, bag1.iterator().next());

        Iterator<Integer> it = bag2.iterator();
        int i = 1;
        while (it.hasNext())
            assertEquals(i++, it.next());
        bag2.add(0);
        i = 0;
        while (it.hasNext())
            assertEquals(i++, it.next());
    }

    @Test
    void testDeleteAndIterator() {
        System.out.println("Testing delete and iterator.");

        bag1.delete(0);
        assertFalse(bag1.iterator().hasNext());

        bag2.delete(1);
        Iterator<Integer> it = bag2.iterator();
        int i = 2;
        while (it.hasNext())
            assertEquals(i++, it.next());
    }
}
