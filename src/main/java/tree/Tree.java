package tree;

/**
 * An interface of binary search tree.
 *
 * @param <K> key type of node.
 * @param <V> value type of node.
 */
public interface Tree<K extends Comparable<K>, V> {
    V get(K key);

    void put(K key, V val);
}
