package hash;

/**
 * An interface of hash search table.
 *
 * @param <K> key type of nodes.
 * @param <V> value type of nodes.
 */
public interface HashSearchTable<K, V> {
    V get(K key);

    void put(K key, V val);

    default int hash(K key, int M) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
}
