package Search.test;

import Search.FindMaxLength;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMaxLengthTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting FindMaxLengthTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished FindMaxLengthTest.");
    }

    private void testSolution(FindMaxLength.Solution solution) {
        assertEquals(0, solution.findMaxLength(new int[]{1}));
        assertEquals(2, solution.findMaxLength(new int[]{0, 1}));
        assertEquals(2, solution.findMaxLength(new int[]{0, 0, 1}));
        assertEquals(6, solution.findMaxLength(new int[]{0, 1, 1, 0, 0, 1, 1, 1, 0}));
        assertEquals(6, solution.findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }

    @Test
    public void testSolution1() {
        System.out.println("Testing solution 1.");

        FindMaxLength.Solution solution = new FindMaxLength.Solution1();
        testSolution(solution);
    }
}
