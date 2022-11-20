package LinkedList;

import java.util.Iterator;

/**
 * An implementation of bag.
 *
 * @param <T> type of elements.
 */
public class Bag<T> implements Iterable<T> {
    private Node first;//first one of nodes in list

    public void add(T item) {
        Node old = first;
        first = new Node(item, old);
    }

    public void delete(T item) {
        first = delete(first, item);
    }

    private Node delete(Node head, T item) {
        if (head == null) return null;
        Node node = new Node(null, first);
        while (node.next != null) {
            if (item.equals(node.next.item)) node.next = node.next.next;
            else node = node.next;
        }
        return head.next;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        T item;
        Node next;

        private Node(T item) {
            this.item = item;
        }

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
