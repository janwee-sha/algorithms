package bubblesort.test;

import bubblesort.BubbleSort;
import bucketsort.test.SortTest;
import org.junit.jupiter.api.Test;

public class BubbleSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new BubbleSort());
    }
}
