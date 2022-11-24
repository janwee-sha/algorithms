package mergesort.test;

import bucketsort.test.SortTest;
import mergesort.MergeSort;
import org.junit.jupiter.api.Test;

public class MergeSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new MergeSort());
    }
}
