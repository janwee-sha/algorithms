package BucketSort.test;

import BucketSort.BucketSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BucketSortTest {
    private int[] arr1, arr2, arr3, arr4;

    @BeforeEach
    void initialize() {
        System.out.println("Setting up instances of input array.");

        arr1 = new int[0];
        arr2 = new int[]{0};
        arr3 = new int[]{1, 0};
        arr4 = new int[]{1, 1, 0, 3, 4, 2, -1, -1};
    }

    @Test
    public void testSolution() {
        BucketSort solution = new BucketSort();
        assertArrayEquals(new int[0], solution.sort(arr1));
        assertArrayEquals(new int[]{0}, solution.sort(arr2));
        assertArrayEquals(new int[]{0, 1}, solution.sort(arr3));
        assertArrayEquals(new int[]{-1, -1, 0, 1, 1, 2, 3, 4}, solution.sort(arr4));
    }
}
