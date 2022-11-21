package MergeSort.test;

import BucketSort.test.SortTest;
import HeapSort.HeapSort;
import MergeSort.MergeSort;
import org.junit.jupiter.api.Test;

public class MergeSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new MergeSort());
    }
}
