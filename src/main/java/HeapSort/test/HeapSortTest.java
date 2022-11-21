package HeapSort.test;

import BucketSort.test.SortTest;
import HeapSort.HeapSort;
import org.junit.jupiter.api.Test;

public class HeapSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new HeapSort());
    }
}
