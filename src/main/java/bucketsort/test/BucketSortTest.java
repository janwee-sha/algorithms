package bucketsort.test;

import bucketsort.BucketSort;
import org.junit.jupiter.api.Test;

public class BucketSortTest extends SortTest {

    @Test
    public void test() {
        testSolution(new BucketSort());
    }
}
