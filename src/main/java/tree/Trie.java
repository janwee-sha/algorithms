package tree;

/**
 * An implementation of Trie tree (word search tree).
 */
public class Trie {
    private static final int SIZE = 26;
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        if (word == null || word.length() == 0) return;

        Node node = root;
        char[] cs = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int pos = cs[i] - 'a';
            if (node.children[pos] == null) node.children[pos] = new Node(cs[i]);
            else node.children[pos].num++;
            node = node.children[pos];
        }
    }

    public int countPrefix(String word) {
        if (word == null || word.length() == 0) return 0;

        Node node = root;
        char[] cs = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int pos = cs[i] - 'a';
            if (node.children[pos] == null) return 0;
            node = node.children[pos];
        }
        return node.num;
    }

    private static class Node {
        private int num;
        private Node[] children;
        private char val;
        private boolean hasChildren;

        public Node() {
            num = 1;
            children = new Node[SIZE];
            hasChildren = false;
        }

        public Node(char val) {
            this();
            this.val = val;
            this.hasChildren = true;
        }
    }
}