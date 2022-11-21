package QuickSort;

import BucketSort.Sort;

//Implementation of quick quickSort.
//通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另一部分要小，
//然后再按此方法依次对两部分数据分别递归地进行快速排序。
//best time complexity:O(n*log₂n),worst time complexity:O(n²),space complexity:O(1).
public class QuickSort implements Sort {
    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q, r);
        }
    }

    private int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i + 1, j);
                i++;
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
}
