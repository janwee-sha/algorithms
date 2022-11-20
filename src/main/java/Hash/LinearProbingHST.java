package Hash;

/**
 * An implementation of linear probing hash search table.
 *
 * @param <K> key type of nodes.
 * @param <V> value type of nodes.
 */
public class LinearProbingHST<K, V>
        implements HashSearchTable<K, V> {
    private int N;//number of key-value pairs.
    private int M;//size of hash search table.
    private K[] keys;//keys
    private V[] vals;//values

    public LinearProbingHST() {
        this(16);
    }

    @SuppressWarnings("unchecked")
    public LinearProbingHST(int cap) {
        M = cap;
        keys = (K[]) new Object[M];
        vals = (V[]) new Object[M];
    }

    private int hash(K key) {
        return hash(key, M);
    }

    private void resize(int cap) {
        LinearProbingHST<K, V> t;
        t = new LinearProbingHST<>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null) t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    @Override
    public V get(K key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) return vals[i];
        return null;
    }

    @Override
    public void put(K key, V val) {
        if (N >= M / 2) resize(2 * M);//double the value of M

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
}
