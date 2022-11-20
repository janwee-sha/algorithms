package Cases;

import java.util.Random;

//Given an integer array a. Write an algorithm that finds the k-th largest element in the array.
//1 <= k <= nums.length <= 10^5
//-10^4 <= nums[i] <= 10^4
public class KthLargestElement {
    private Random random = new Random();

    public int kthLargestElement(int[] a, int k) {
        return quickSelect(a, 0, a.length - 1, a.length - k);
    }

    private int quickSelect(int[] a, int start, int end, int target) {
        int separator = partition(a, start, end);
        if (separator == target) {
            return a[separator];
        }
        return separator < target ? quickSelect(a, separator + 1, end, target)
                : quickSelect(a, start, separator - 1, target);
    }

    private int partition(int[] a, int start, int end) {
        int picked = random.nextInt(end - start + 1) + start;
        swap(a, picked, end);
        int pivot = a[end], lessEnd = start - 1;
        for (int curr = start; curr < end; curr++) {
            if (a[curr] <= pivot) {
                swap(a, ++lessEnd, curr);
            }
        }
        swap(a, lessEnd + 1, end);
        return lessEnd + 1;
    }

    private void swap(int[] a, int one, int other) {
        int k = a[one];
        a[one] = a[other];
        a[other] = k;
    }
}
