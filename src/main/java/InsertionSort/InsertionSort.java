package InsertionSort;

import BucketSort.Sort;

//Implementation of Insertion Sort.
public class InsertionSort implements Sort {
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j] < arr[j + 1]) break;
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        return arr;
    }
}
