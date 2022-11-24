package selectionsort;

import bucketsort.Sort;

//Implementation of Selection Sort.
//从待排元素中选择最小（或最大）的一个元素，存放再序列的起始（或末尾）位置，
//然后再从剩余的未排序元素中寻找最小（或最大）元素，存放到未排序队列的起始位置，
//重复进行直至待排元素个数为0。
//best time complexity:O(n),worst time complexity:O(n²),space complexity:O(1).
public class SelectionSort implements Sort {
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) if (arr[j] < arr[min]) min = j;
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
