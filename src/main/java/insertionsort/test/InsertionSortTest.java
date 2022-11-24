package insertionsort.test;

import bucketsort.test.SortTest;
import insertionsort.InsertionSort;
import org.junit.jupiter.api.Test;

public class InsertionSortTest extends SortTest {

    @Test
    public void test() {
        testSolution(new InsertionSort());
    }
}
