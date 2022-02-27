package linkedlist;

/**
 * Sequential search.
 *
 * @param <K> key type of nodes.
 * @param <V> value type of nodes.
 */
public class SequentialSearchST<K, V> {
    private Node first;

    public V get(K key) {
        for (Node n = first; n != null; n = n.next)
            if (key.equals(n.key)) return n.val;
        return null;
    }

    public void put(K key, V val) {
        for (Node n = first; n != null; n = n.next)
            if (key.equals(n.key)) {
                n.val = val;
                return;
            }
        first = new Node(key, val, first);
    }

    public void delete(K key) {
        first = delete(first, key);
    }

    private Node delete(Node head, K key) {
        if (head == null) return null;
        Node node = new Node(null, null, first);
        head = node;
        while (node.next != null) {
            if (key.equals(node.next.key)) node.next = node.next.next;
            else node = node.next;
        }
        return head.next;
    }

    private class Node {
        K key;
        V val;
        Node next;

        private Node(K key, V val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
