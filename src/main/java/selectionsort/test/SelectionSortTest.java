package selectionsort.test;

import bucketsort.test.SortTest;
import selectionsort.SelectionSort;
import org.junit.jupiter.api.Test;

public class SelectionSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new SelectionSort());
    }
}
