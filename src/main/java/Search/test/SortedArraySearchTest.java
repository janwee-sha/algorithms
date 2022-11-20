package Search.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Search.SortedArraySearch;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortedArraySearchTest {
    private int[] nums1, nums2, nums3;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting SortedArraySearchTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished SortedArraySearchTest.");
    }

    @BeforeEach
    void initialize() {
        nums1 = new int[0];
        nums2 = new int[]{1, 1};
        nums3 = new int[]{-1, 1, 2, 3, 6, 8, 9};
    }

    private void testSolution(SortedArraySearch.Solution solution) {
        assertEquals(-1, solution.search(nums1, 4));
        assertEquals(-1, solution.search(nums2, 0));
        assertEquals(0, solution.search(nums2, 1));
        assertEquals(0, solution.search(nums3, -1));
        assertEquals(6, solution.search(nums3, 9));
        assertEquals(3, solution.search(nums3, 3));
        assertEquals(-1, solution.search(nums3, -2));
        assertEquals(-1, solution.search(nums3, 10));
        assertEquals(-1, solution.search(nums3, 5));
    }

    @Test
    void testSequentialSearch(){
        System.out.println("Testing SequentialSearch.");
        testSolution(new SortedArraySearch.SequentialSearch());
    }

    @Test
    void testBinarySearch() {
        System.out.println("Testing BinarySearch.");
        testSolution(new SortedArraySearch.BinarySearch());
    }

    @Test
    void testRecursiveBinarySearch() {
        System.out.println("Testing RecursiveBinarySearch.");
        testSolution(new SortedArraySearch.RecursiveBinarySearch());
    }
}
