package BubbleSort.test;

import BubbleSort.BubbleSort;
import BucketSort.test.SortTest;
import org.junit.jupiter.api.Test;

public class BubbleSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new BubbleSort());
    }
}
