package Cases.test;

import Cases.IsPowerOfFour;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPowerOfFourTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting IsPowerOfTwoTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished IsPowerOfTwoTest.");
    }

    private void test(IsPowerOfFour.Solution solution) {
        assertFalse(solution.isPowerOfFour(Integer.MIN_VALUE));
        assertFalse(solution.isPowerOfFour(-4));
        assertFalse(solution.isPowerOfFour(0));
        assertTrue(solution.isPowerOfFour(1));
        assertTrue(solution.isPowerOfFour(4));
        assertTrue(solution.isPowerOfFour(64));
        assertTrue(solution.isPowerOfFour(1_073_741_824));
        assertFalse(solution.isPowerOfFour(Integer.MAX_VALUE));
    }

    @Test
    public void testSolution1() {
        System.out.println("Testing solution 1.");

        IsPowerOfFour.Solution s = new IsPowerOfFour.Solution1();
        test(s);
    }

    @Test
    public void testSolution2() {
        System.out.println("Testing solution 2.");

        IsPowerOfFour.Solution s = new IsPowerOfFour.Solution2();
        test(s);
    }
}
