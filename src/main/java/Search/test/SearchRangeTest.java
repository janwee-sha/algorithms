package Search.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Search.SearchRange;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SearchRangeTest {
    private int[] nums1, nums2, nums3, nums4, nums5;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting SearchRangeTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished SearchRangeTest.");
    }

    @BeforeEach
    void initialize() {
        nums1 = new int[0];
        nums2 = new int[]{0};
        nums3 = new int[]{1, 1};
        nums4 = new int[]{-1, 1, 2, 3, 3, 3, 6, 8, 9};
        nums5 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    private void testSolution(SearchRange.Solution solution) {
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(nums1, 4));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(nums2, 1));
        assertArrayEquals(new int[]{0, 0}, solution.searchRange(nums2, 0));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(nums3, 2));
        assertArrayEquals(new int[]{0, 1}, solution.searchRange(nums3, 1));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(nums4, 0));
        assertArrayEquals(new int[]{3, 5}, solution.searchRange(nums4, 3));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(nums5, 0));
        assertArrayEquals(new int[]{0, 10}, solution.searchRange(nums5, -1));
    }

    @Test
    void testBinarySearch() {
        System.out.println("Testing BinarySearch.");
        testSolution(new SearchRange.BinarySearch());
    }
}
