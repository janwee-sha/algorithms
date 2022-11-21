package ShellsSort.test;

import BucketSort.test.SortTest;
import ShellsSort.ShellsSort;
import org.junit.jupiter.api.Test;

public class ShellSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new ShellsSort());
    }
}
