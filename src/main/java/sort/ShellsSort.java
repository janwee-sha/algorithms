package sort;

//Implementation of Shell's Sort.
//是直接插入排序的一种改进版本，又称“缩小增量排序”。
public class ShellsSort implements Sort {
    public int[] sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            for (int i = 0; i < arr.length - gap; i++) {
                for (int j = i; j >= 0; j -= gap) {
                    if (arr[j] < arr[j + gap]) break;
                    int temp = arr[j];
                    arr[j] = arr[j + gap];
                    arr[j + gap] = temp;
                }
            }
        }
        return arr;
    }
}