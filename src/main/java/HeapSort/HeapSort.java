package HeapSort;

public class HeapSort {
    private int[] heap;
    private int heapSize;

    public int[] sort(int[] arr) {
        heap = new int[arr.length];
        heapSize = 0;
        buildMaxHeap(arr);
        while (heapSize > 0) {
            swap(0, heapSize - 1);
            heapSize--;
            shiftDown(0);
        }
        return heap;
    }

    private void buildMaxHeap(int[] arr) {
        for (int elem : arr) {
            heap[heapSize] = elem;
            shiftUp(heapSize++);
        }
    }

    private void shiftUp(int index) {
        int parent = (index - 1) / 2;
        if (parent >= 0 && heap[parent] < heap[index]) {
            swap(parent, index);
            shiftUp(parent);
        }
    }

    private void shiftDown(int index) {
        int left = 2 * index + 1, right = 2 * index + 2;
        if ((left < heapSize && right >= heapSize)
                || (left < heapSize && right < heapSize && heap[left] > heap[right])) {
            if (heap[index] < heap[left]) {
                swap(left, index);
                shiftDown(left);
            }
        } else if (right < heapSize) {
            if (heap[index] < heap[right]) {
                swap(right, index);
                shiftDown(right);
            }
        }
    }

    private void swap(int first, int next) {
        int swap = heap[first];
        heap[first] = heap[next];
        heap[next] = swap;
    }
}
