package BucketSort;

import java.util.ArrayList;
import java.util.List;

//桶排序（Bucket sort），又称箱排序。原理是将数组分到有限数量的同理。
// 每个桶再个别排序（可能使用别的排序算法或是以递归方式继续进行桶排序）。
public class BucketSort implements Sort{
    private int indexFor(int elem, int min, int step) {
        return (elem - min) / step;
    }

    public int[] sort(int[] arr) {
        if (arr.length < 2) return arr;

        int max = arr[0], min = arr[0];
        for (int e : arr) {
            if (max < e) max = e;
            if (min > e) min = e;
        }

        //该值可根据实际情况进行选择
        int buckNum = max / 2 - min / 2 + 1;
        List<List<Integer>> buckList = new ArrayList<>();

        // create bucket
        for (int i = 1; i <= buckNum; i++) buckList.add(new ArrayList<>());

        // push into the bucket
        for (int e : arr) buckList.get(indexFor(e, min, 2)).add(e);
        ArrayList<Integer> bucket;
        int index = 0;
        for (int i = 0; i < buckNum; i++) {
            bucket = (ArrayList<Integer>) buckList.get(i);
            insertionSort(bucket);
            for (int e : bucket) {
                arr[index++] = e;
            }
        }
        return arr;
    }

    // 把桶內元素插入排序
    private void insertionSort(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int temp = bucket.get(i);
            int j = i - 1;
            for (; j >= 0 && bucket.get(j) > temp; j--) bucket.set(j + 1, bucket.get(j));
            bucket.set(j + 1, temp);
        }
    }
}
