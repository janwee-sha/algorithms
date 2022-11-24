package btree;

import java.util.List;

/**
 * An implementation of B-Tree
 *
 * @param <K> key
 * @param <V> value
 */
public class BTree<K extends Comparable<K>, V> {
    private Node<K, V> root;
    private int minDegree;

    public BTree(Node<K, V> root, int minDegree) {
        this.root = root;
        this.minDegree = minDegree;
    }

    public V get(K key) {
        return get(this.root, key);
    }

    public V get(Node<K, V> node, K key) {
        List<Node.Pair<K, V>> pairs = node.pairs;
        int i = 0;
        while (i < pairs.size() && key.compareTo(pairs.get(i).key) > 0) {
            i++;
        }
        Node.Pair<K, V> pair = pairs.get(i);
        if (key == pair.key) {
            return pair.val;
        } else if (node.isLeaf) {
            return null;
        } else {
            return get(node.children.get(i), key);
        }
    }

    public void insert(K key, V val) {

    }

    private void splitChildren(Node<K, V> nonfullNode, int i) {

    }

    private static class Node<K extends Comparable<K>, V> {
        private BTree<K, V> owner;
        private List<Pair<K, V>> pairs;
        private List<Node<K, V>> children;
        private boolean isLeaf;

        private static class Pair<K extends Comparable<K>, V> {
            private K key;
            private V val;

            public Pair(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
