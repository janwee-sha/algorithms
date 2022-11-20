package BitOperation.test;

import BitOperation.TotalHammingDistance;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalHammingDistanceTest {
    private int[] nums1, nums2;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting TotalHammingDistanceTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished TotalHammingDistanceTest.");
    }

    @BeforeEach
    public void initialize() {
        System.out.println("Setting up arrays of int.");

        nums1 = new int[]{4, 14, 2};
        nums2 = new int[]{};
    }

    @Test
    public void testSolution1() {
        System.out.println("Testing solution 1.");

        TotalHammingDistance.Solution1 solution1 = new TotalHammingDistance.Solution1();

        assertEquals(6, solution1.totalHammingDistance(nums1));
        assertEquals(0, solution1.totalHammingDistance(nums2));
    }
}
