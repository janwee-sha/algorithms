package Search.test;

import Search.SubarraySum;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubarraySumTest {
    int[] nums1, nums2, nums3;
    int k1, k2, k3;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting IsPowerOfTwoTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished IsPowerOfTwoTest.");
    }

    @BeforeEach
    public void initialize() {
        nums1 = new int[0];
        k1 = 0;
        nums2 = new int[]{1, 1, 1};
        k2 = 2;
        nums3 = new int[]{2, 8, -9, 19, 0, 10, -10};
        k3 = 10;
    }

    public void test(SubarraySum.Solution solution) {
        assertEquals(0, solution.subarraySum(nums1, k1));
        assertEquals(2, solution.subarraySum(nums2, k2));
        assertEquals(6, solution.subarraySum(nums3, k3));
    }

    @Test
    public void testSolution1() {
        System.out.println("Testing solution1.");
        SubarraySum.Solution solution = new SubarraySum.Solution1();
        test(solution);
    }

    @Test
    public void testSolution2() {
        System.out.println("Testing solution2.");
        SubarraySum.Solution solution = new SubarraySum.Solution2();
        test(solution);
    }
}
