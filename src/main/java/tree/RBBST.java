package tree;

/**
 * An implementation of red-black binary search tree.
 *
 * @param <K> key type of node.
 * @param <V> value type of node.
 */
public class RBBST<K extends Comparable<K>, V>
        implements Tree<K, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node<K, V> root;

    //左旋并返回子树根结点
    public static <Key extends Comparable<Key>, Val> Node<Key, Val> rotateLeft(Node<Key, Val> node) {
        Node<Key, Val> right = node.right;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = RED;
        return right;
    }

    //右旋并返回子树根结点
    public static <Key extends Comparable<Key>, Val> Node<Key, Val> rotateRight(Node<Key, Val> node) {
        Node<Key, Val> left = node.left;
        node.left = left.right;
        left.right = node;
        node.color = left.color;
        left.color = RED;
        return left;
    }

    //变换指向当前结点左右子结点的红链接和指向自己的黑链接的颜色
    //以分解4-结点
    public static <Key extends Comparable<Key>, Val> void flipColors(Node<Key, Val> node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private static <Key extends Comparable<Key>, Val> boolean isRed(Node<Key, Val> node) {
        return node != null && node.color == RED;
    }

    private static <Key extends Comparable<Key>, Val> Node<Key, Val> insert(
            Node<Key, Val> node, Key key, Val val) {
        if (node == null) return new Node<>(key, val);
        int compare = key.compareTo(node.key);
        if (compare < 0) node.left = insert(node.left, key, val);
        else if (compare > 0) node.right = insert(node.right, key, val);
        else node.val = val;

        if (!isRed(node.left) && isRed(node.right)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        return node;
    }

    private static <Key extends Comparable<Key>, Val> Val get(Node<Key, Val> node, Key key) {
        if (node == null) return null;

        int compare = key.compareTo(node.key);
        if (compare < 0) return get(node.left, key);
        else if (compare > 0) return get(node.right, key);
        else return node.val;
    }

    public V get(K key) {
        return get(root, key);
    }

    public void insert(K key, V val) {
        root = insert(root, key, val);
        root.color = BLACK;
    }

    private static class Node<K extends Comparable<K>, V> {
        private boolean color;//父节点指向本节点的链接的颜色
        private K key;
        private V val;
        private Node<K, V> left, right;

        private Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.color = RED;
        }

        public Node(K key, V val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }
}
