package search;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 */
public class SearchRange {
    public interface Solution {
        int[] searchRange(int[] nums, int target);
    }

    //利用二分法寻找第一个等于target的位置和第一个大于target的位置减1
    public static class BinarySearch implements Solution {
        public int[] searchRange(int[] nums, int target) {
            int low = search(nums, target, true), high = search(nums, target, false) - 1;
            if (low <= high && high < nums.length && nums[low] == target && nums[high] == target)
                return new int[]{low, high};
            return new int[]{-1, -1};
        }

        //left为true表示查找开始位置，为false表示查找结束位置
        public int search(int[] nums, int target, boolean left) {
            int ans = nums.length, low = 0, high = ans - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] > target || (left && nums[mid] == target)) {
                    high = mid - 1;
                    ans = mid;
                } else low = mid + 1;
            }
            return ans;
        }
    }
}
