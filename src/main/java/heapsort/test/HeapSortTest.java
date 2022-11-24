package heapsort.test;

import bucketsort.test.SortTest;
import heapsort.HeapSort;
import org.junit.jupiter.api.Test;

public class HeapSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new HeapSort());
    }
}
