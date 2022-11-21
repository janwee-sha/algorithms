package InsertionSort.test;

import BucketSort.test.SortTest;
import InsertionSort.InsertionSort;
import org.junit.jupiter.api.Test;

public class InsertionSortTest extends SortTest {

    @Test
    public void test() {
        testSolution(new InsertionSort());
    }
}
