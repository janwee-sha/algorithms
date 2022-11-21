package BubbleSort;

import BucketSort.Sort;

//Implementation of Bubble Sort.
//重复地走访要排序地元素列，依次比较两个相邻元素，若顺序错误就交换两个元素的位置，
//重复进行走访直至没有元素需要交换。
//best time complexity:O(n),worst time complexity:O(n²),space complexity:O(1).
public class BubbleSort implements Sort {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
