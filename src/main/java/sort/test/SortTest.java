package sort.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sort.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {
    private int[] arr1, arr2, arr3, arr4;

    @BeforeEach
    void initialize() {
        System.out.println("Setting up instances of input array.");

        arr1 = new int[0];
        arr2 = new int[]{0};
        arr3 = new int[]{1, 0};
        arr4 = new int[]{1, 1, 0, 3, 4, 2, -1, -1};
    }

    private void testSolution(Sort sort) {
        assertArrayEquals(new int[0], sort.sort(arr1));
        assertArrayEquals(new int[]{0}, sort.sort(arr2));
        assertArrayEquals(new int[]{0, 1}, sort.sort(arr3));
        assertArrayEquals(new int[]{-1, -1, 0, 1, 1, 2, 3, 4}, sort.sort(arr4));
    }

    @Test
    void testBubbleSort() {
        System.out.println("Testing Bubble Sort.");
        testSolution(new BubbleSort());
    }

    @Test
    void testQuickSort() {
        System.out.println("Testing Quick Sort.");
        testSolution(new QuickSort());
    }

    @Test
    void testSelectionSort() {
        System.out.println("Testing Selection Sort.");
        testSolution(new SelectionSort());
    }

    @Test
    void testInsertionSort() {
        System.out.println("Testing Insertion Sort.");
        testSolution(new InsertionSort());
    }

    @Test
    void testShellsSort() {
        System.out.println("Testing Shell's Sort.");
        testSolution(new ShellsSort());
    }

    @Test
    void testMergeSort() {
        System.out.println("Testing Merge Sort.");
        testSolution(new MergeSort());
    }

    @Test
    void testBucketSort(){
        System.out.println("Testing Bucket Sort.");
        testSolution(new BucketSort());
    }

    @Test
    void testHeapSort() {
        System.out.println("Testing Heap Sort.");
        testSolution(new HeapSort());
    }
}
