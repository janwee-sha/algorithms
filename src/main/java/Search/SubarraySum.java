package Search;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class SubarraySum {
    public interface Solution {
        int subarraySum(int[] nums, int k);
    }

    //time complexity:O(N^2)、space complexity:O(1)
    public static class Solution1 implements Solution {
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum == k) ans++;
                }
            }
            return ans;
        }
    }

    //time complexity:O(N)、space complexity:O(N)
    public static class Solution2 implements Solution {
        public int subarraySum(int[] nums, int k) {
            int ans = 0, pre = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int num : nums) {
                pre += num;
                if (map.containsKey(pre - k)) ans += map.get(pre - k);
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return ans;
        }
    }
}