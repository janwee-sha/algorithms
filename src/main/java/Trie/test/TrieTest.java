package Trie.test;

import static org.junit.jupiter.api.Assertions.*;

import Trie.Trie;
import org.junit.jupiter.api.Test;

public class TrieTest {
    @Test
    public void testContains(){
        Trie trie = new Trie();
        assertFalse(trie.contains("ohayou"));
        trie.insert("ohayougozaimasu");
        assertTrue(trie.contains("ohayougozaimasu"));
        assertFalse(trie.contains("ohayou"));
    }
}
