package heap;

public class Heap<E extends Comparable> {
    private Object[] elements;
    private int heapSize;

    public Heap(int capacity) {
        this.elements = new Object[capacity];
        heapSize = 0;
    }

    private void shiftUp(int index) {
        int parent = (index - 1) / 2;
        if (parent >= 0 && compareElements(element(parent), element(index)) < 0) {
            swapElements(parent, index);
            shiftUp(parent);
        }
    }

    private void shiftDown(int index) {
        int left = 2 * index + 1, right = 2 * index + 2;
        if ((left < heapSize && right >= heapSize)
                || (left < heapSize && right < heapSize && compareElements(element(left), element(right)) > 0)) {
            if (compareElements(element(index), element(left)) < 0) {
                swapElements(left, index);
                shiftDown(left);
            }
        } else if (right < heapSize) {
            if (compareElements(element(index), element(right)) < 0) {
                swapElements(right, index);
                shiftDown(right);
            }
        }
    }

    private void swapElements(int first, int next) {
        E swap = element(first);
        elements[first] = elements[next];
        elements[next] = swap;

    }

    @SuppressWarnings("unchecked")
    private E element(int index) {
        return (E) elements[index];
    }

    @SuppressWarnings("unchecked")
    private int compareElements(E origin, E target) {
        return origin.compareTo(target);
    }

    public boolean insert(E value) {
        if (heapSize == elements.length) return false;
        elements[heapSize] = value;
        shiftUp(heapSize++);
        return true;
    }

    public E remove() {
        if (heapSize == 0) return null;
        E removed = element(0);
        elements[0] = elements[heapSize - 1];
        elements[heapSize - 1] = null;
        heapSize--;
        shiftDown(0);
        return removed;
    }

    public int size() {
        return heapSize;
    }
}
