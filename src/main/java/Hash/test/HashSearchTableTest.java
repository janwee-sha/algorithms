package Hash.test;

import Hash.HashSearchTable;
import Hash.LinearProbingHST;
import Hash.SeparateChainingHST;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashSearchTableTest {
    private HashSearchTable<String, String> st1, st2;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting HashSearchTableTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished HashSearchTableTest.");
    }

    private void initializeSt1() {
        System.out.println("Setting up instance of SeparateChainingHashST.");

        st1 = new SeparateChainingHST<>();
        st1.put("Holmes", "Sherlock");
        st1.put("Watson", "John");
        st1.put("Baggins", "Frodo");
        st1.put("Gamgee", "Samwise");
    }

    private void initializeSt2() {
        System.out.println("Setting up instance of LinearProbingHST.");

        st2 = new LinearProbingHST<>();
        st2.put("Holmes", "Sherlock");
        st2.put("Watson", "John");
        st2.put("Baggins", "Frodo");
        st2.put("Gamgee", "Samwise");
    }

    private void testGet(HashSearchTable<String, String> st) {
        assertEquals("Sherlock", st.get("Holmes"));
        assertEquals("John", st.get("Watson"));
        assertEquals("Frodo", st.get("Baggins"));
        assertEquals("Samwise", st.get("Gamgee"));
        assertNull(st.get("Gandalf"));
    }

    private void testPut(HashSearchTable<String, String> st) {
        assertNull(st.get("Gandalf"));
        st.put("Gandalf", "Mithrandir");
        assertEquals("Mithrandir", st.get("Gandalf"));

        st.put("Baggins", "Bilbo");
        assertEquals("Bilbo", st.get("Baggins"));
    }

    @Test
    public void testSCHSTGet() {
        initializeSt1();
        System.out.println("Testing get method of SeparateChainingHST.");
        testGet(st1);
    }

    @Test
    public void testSCHSTPut() {
        initializeSt1();
        System.out.println("Testing put method of SeparateChainingHST.");
        testPut(st1);
    }

    @Test
    public void testLPHSTGet() {
        initializeSt2();
        System.out.println("Testing get method of LinearProbingHST.");
        testGet(st2);
    }

    @Test
    public void testLPHSTPut() {
        initializeSt2();
        System.out.println("Testing put method of LinearProbingHST.");
        testPut(st2);
    }
}
