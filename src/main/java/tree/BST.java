package tree;

/**
 * An implementation of binary search tree.
 * @param <K> key type of node.
 * @param <V> value type of node.
 */
public class BST<K extends Comparable<K>, V>
        implements Tree<K, V> {
    private Node<K, V> root;

    private static <Key extends Comparable<Key>, Val> Val get(Node<Key, Val> node, Key key) {
        if (node == null) return null;

        int compare = key.compareTo(node.key);
        if (compare < 0) return get(node.left, key);
        else if (compare > 0) return get(node.right, key);
        else return node.val;
    }

    private static <Key extends Comparable<Key>, Val> Node<Key, Val> insert(Node<Key, Val> node, Key key, Val val) {
        if (node == null) return new Node<>(key, val);
        int compare = key.compareTo(node.key);
        if (compare < 0) node.left = insert(node.left, key, val);
        else if (compare > 0) node.right = insert(node.right, key, val);
        else node.val = val;
        return node;
    }

    public void insert(K key, V val) {
        root = insert(root, key, val);
    }

    public void remove(K key) {

    }

    public V get(K key) {
        return get(root, key);
    }

    public K min() {
        return min(root);
    }

    private K min(Node<K, V> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.key;
        }
        return min(node.left);
    }

    public K max() {
        return max(root);
    }

    private K max(Node<K, V> node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.key;
        }
        return max(node.right);
    }

    private static class Node<K extends Comparable<K>, V> {
        private K key;
        private V val;
        private Node<K, V> left, right;

        private Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
