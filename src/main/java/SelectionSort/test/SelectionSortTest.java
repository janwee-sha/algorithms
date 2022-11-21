package SelectionSort.test;

import BucketSort.test.SortTest;
import SelectionSort.SelectionSort;
import org.junit.jupiter.api.Test;

public class SelectionSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new SelectionSort());
    }
}
