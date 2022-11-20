package Search;

public class SortedArraySearch {
    public interface Solution {
        int search(int[] nums, int target);
    }

    public static class SequentialSearch implements Solution {
        public int search(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++)
                if (nums[i] == target) return i;
            return -1;
        }
    }

    public static class BinarySearch implements Solution {
        public int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1, mid;
            while (low <= high) {
                if (nums[low] == target) return low;
                if (nums[high] == target) return high;
                mid = (low + high) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] > target) high = mid - 1;
                else low = mid + 1;
            }
            return -1;
        }
    }

    public static class RecursiveBinarySearch implements Solution {
        public static int search(int[] nums, int target, int low, int high) {
            if (low <= high) {
                if (nums[low] == target) return low;
                if (nums[high] == target) return high;
                int mid = (low + high) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] > target) return search(nums, target, low, mid - 1);
                if (nums[mid] < target) return search(nums, target, mid + 1, high);
            }
            return -1;
        }

        public int search(int[] nums, int target) {
            return search(nums, target, 0, nums.length - 1);
        }
    }
}
