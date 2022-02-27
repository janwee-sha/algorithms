package tree.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree.Trie;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for Trie.
 */
public class TrieTest {
    private Trie trie;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting TrieTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished TrieTest.");
    }

    @BeforeEach
    public void initialize() {
        System.out.println("Setting up instance of Trie.");
        trie = new Trie();
    }

    @Test
    public void testInsertAndCountPrefix() {
        System.out.println("Testing insert and countPrefix for Trie class.");

        assertEquals(0, trie.countPrefix("concurren"));
        trie.insert("concurrency");
        trie.insert("concurrent");
        assertEquals(2, trie.countPrefix("concurren"));
    }
}
