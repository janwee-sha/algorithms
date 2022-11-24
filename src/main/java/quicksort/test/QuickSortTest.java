package quicksort.test;

import bucketsort.test.SortTest;
import quicksort.QuickSort;
import org.junit.jupiter.api.Test;

public class QuickSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new QuickSort());
    }
}
