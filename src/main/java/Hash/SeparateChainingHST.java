package Hash;

import LinkedList.SequentialSearchST;

/**
 * An implementation of separate chaining hash search table.
 *
 * @param <K> key type of nodes.
 * @param <V> value type of nodes.
 */
public class SeparateChainingHST<K, V>
        implements HashSearchTable<K, V> {
    private int N;//numbers of key-value pairs.
    private int M;//size of hash search table.
    private SequentialSearchST<K, V>[] st;//array storing linked lists

    public SeparateChainingHST() {
        this(997);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHST(int M) {
        this.M = M;
        st = new SequentialSearchST[M];
        for (int i = 0; i < M; i++)
            st[i] = new SequentialSearchST<>();
    }

    private int hash(K key) {
        return hash(key, M);
    }

    public V get(K key) {
        return st[hash(key)].get(key);
    }

    public void put(K key, V val) {
        st[hash(key)].put(key, val);
    }

    public Iterable<K> keys() {
        //to be finished.
        return null;
    }
}
