package bitoperation.test;

import bitoperation.IsPowerOfTwo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPowerOfTwoTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting IsPowerOfTwoTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished IsPowerOfTwoTest.");
    }

    private void test(IsPowerOfTwo.Solution solution) {
        assertFalse(solution.isPowerOfTwo(Integer.MIN_VALUE));
        assertFalse(solution.isPowerOfTwo(-2));
        assertFalse(solution.isPowerOfTwo(0));
        assertTrue(solution.isPowerOfTwo(1));
        assertTrue(solution.isPowerOfTwo(2));
        assertTrue(solution.isPowerOfTwo(128));
        assertTrue(solution.isPowerOfTwo(1_073_741_824));
        assertFalse(solution.isPowerOfTwo(Integer.MAX_VALUE));
    }

    @Test
    public void testSolution1() {
        System.out.println("Testing solution 1.");

        IsPowerOfTwo.Solution s = new IsPowerOfTwo.Solution1();
        test(s);
    }

    @Test
    public void testSolution2() {
        System.out.println("Testing solution 2.");

        IsPowerOfTwo.Solution s = new IsPowerOfTwo.Solution2();
        test(s);
    }

    @Test
    public void testSolution3(){
        System.out.println("Testing solution 3.");

        IsPowerOfTwo.Solution s = new IsPowerOfTwo.Solution3();
        test(s);
    }
}
