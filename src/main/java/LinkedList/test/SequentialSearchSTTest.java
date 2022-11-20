package LinkedList.test;

import LinkedList.SequentialSearchST;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SequentialSearchSTTest {
    private SequentialSearchST<Integer, String> st;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting SequentialSearchSTTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished SequentialSearchSTTest.");
    }

    @BeforeEach
    void initialize() {
        System.out.println("Setting up instance of SequentialSearchST.");

        st = new SequentialSearchST<>();
        st.put(1, "sherlock");
        st.put(2, "aragorn");
        st.put(3, "gandalf");
        st.put(4, "john");
    }

    @Test
    void testGet() {
        System.out.println("Testing get...");

        assertNull(st.get(5));
        assertEquals("sherlock", st.get(1));
        assertEquals("aragorn", st.get(2));
        assertEquals("gandalf", st.get(3));
        assertEquals("john", st.get(4));
    }

    @Test
    void testPut() {
        System.out.println("Testing put...");

        assertNull(st.get(5));
        st.put(5, "frodo");
        assertEquals("frodo", st.get(5));
        st.put(5, "sam");
        assertEquals("sam", st.get(5));
    }

    @Test
    void testDelete() {
        System.out.println("Testing delete...");

        assertEquals("sherlock", st.get(1));
        st.delete(1);
        assertNull(st.get(1));

        assertEquals("john", st.get(4));
        st.delete(4);
        assertNull(st.get(4));
    }
}
