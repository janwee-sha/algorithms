package QuickSort.test;

import BucketSort.test.SortTest;
import HeapSort.HeapSort;
import QuickSort.QuickSort;
import org.junit.jupiter.api.Test;

public class QuickSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new QuickSort());
    }
}
