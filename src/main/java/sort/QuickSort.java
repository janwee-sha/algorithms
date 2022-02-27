package sort;

//Implementation of quick sort.
//通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另一部分要小，
//然后再按此方法依次对两部分数据分别递归地进行快速排序。
//best time complexity:O(n*log₂n),worst time complexity:O(n²),space complexity:O(1).
public class QuickSort implements Sort {
    public int[] sort(int[] arr) {
        if (arr.length == 0) return arr;
        return sort(arr, 0, arr.length - 1);
    }

    private int[] sort(int[] arr, int low, int high) {
        int i = low, j = high, pivot = arr[low];
        while (i < j) {
            while (i < j && arr[i] < pivot) i++;
            while (i < j && arr[j] > pivot) j--;
            if (i < j && arr[i] == arr[j]) i++;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > low) arr = sort(arr, low, i - 1);
        if (j + 1 < high) arr = sort(arr, j + 1, high);
        return arr;
    }
}
