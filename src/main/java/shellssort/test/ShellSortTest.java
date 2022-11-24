package shellssort.test;

import bucketsort.test.SortTest;
import shellssort.ShellsSort;
import org.junit.jupiter.api.Test;

public class ShellSortTest extends SortTest {
    @Test
    @Override
    public void test() {
        testSolution(new ShellsSort());
    }
}
