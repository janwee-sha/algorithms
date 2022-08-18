package heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {
    @Test
    public void test() {
        Heap<Integer> heap = new Heap<>(10);
        assertEquals(0, heap.size());
        assertNull(heap.remove());
        assertEquals(0, heap.size());
        assertTrue(heap.insert(8));
        assertTrue(heap.insert(2));
        assertTrue(heap.insert(3));
        assertTrue(heap.insert(5));
        assertEquals(4, heap.size());
        assertEquals(8, heap.remove());
        assertEquals(5, heap.remove());
        assertEquals(2, heap.size());
        assertTrue(heap.insert(6));
        assertTrue(heap.insert(8));
        assertTrue(heap.insert(9));
        assertEquals(5, heap.size());
        assertTrue(heap.insert(10));
        assertTrue(heap.insert(1));
        assertTrue(heap.insert(4));
        assertTrue(heap.insert(5));
        assertTrue(heap.insert(7));
        assertFalse(heap.insert(11));
        assertEquals(10, heap.size());
        assertEquals(10, heap.remove());
        assertEquals(9, heap.size());
        assertEquals(9, heap.remove());
        assertEquals(8, heap.remove());
        assertEquals(7, heap.remove());
        assertEquals(6, heap.remove());
        assertEquals(5, heap.remove());
        assertEquals(4, heap.remove());
        assertEquals(3, heap.remove());
        assertEquals(2, heap.remove());
        assertEquals(1, heap.remove());
        assertNull(heap.remove());
        assertEquals(0, heap.size());

        Heap<String> stringHeap = new Heap<>(3);
        assertTrue(stringHeap.insert("Sirius"));
        assertTrue(stringHeap.insert("James Potter"));
        assertEquals("Sirius", stringHeap.remove());
        assertTrue(stringHeap.insert("Harry Potter"));
        assertTrue(stringHeap.insert("Hermione Granger"));
        assertFalse(stringHeap.insert("Albus Dumbledore"));
        assertEquals("James Potter",stringHeap.remove());
        assertTrue(stringHeap.insert("Ron Weasley"));

    }
}
