package sort;

//归并排序，是创建在归并操作上的一种有效的排序算法。
//该算法采用分治法（Divide and Conquer）的一个非常典型的应用，且各层分治递归可以同时进行。
//time complexity:O(n*log₂n)
public class MergeSort implements Sort {
    public int[] sort(int[] arr) {
        if (arr.length == 0) return arr;
        return sort(arr, 0, arr.length - 1);
    }

    private int[] sort(int[] arr, int low, int high) {
        if (low == high) return new int[]{arr[low]};

        int mid = (high + low) / 2;
        int[] lArr = sort(arr, low, mid);//left sorted subarray
        int[] hArr = sort(arr, mid + 1, high);//right sorted subarray

        int[] nArr = new int[lArr.length + hArr.length];
        int i = 0, j = 0, n = 0;
        while (i < lArr.length && j < hArr.length) nArr[n++] = lArr[i] < hArr[j] ? lArr[i++] : hArr[j++];
        while (i < lArr.length) nArr[n++] = lArr[i++];
        while (j < hArr.length) nArr[n++] = hArr[j++];
        return nArr;
    }
}