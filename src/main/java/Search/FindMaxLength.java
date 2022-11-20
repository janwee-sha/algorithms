package Search;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 1 <= nums.length <= 105.
 */
public class FindMaxLength {

    public interface Solution {
        int findMaxLength(int[] nums);
    }

    //sum[i]表示数组[0,i]区间元素之和；若[j+1,i]区间0、1数量相同，则sum[i]-sum[j]==(i-j)/2,即2*sum[i]-i==2*sum[j]-j
    //time complexity:O(N),space complexity:O(N)
    public static class Solution1 implements Solution {
        public int findMaxLength(int[] nums) {
            int sum = 0, ans = 0;//使用sum记录对应i的sum[i]
            Map<Integer, Integer> map = new HashMap<>();
            map.put(1, -1);//若[0,i]区间（j=-1）0、1数量相同,则sum[i]==(i+1)/2,推导得2*sum[i]-i==1
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                int k = 2 * sum - i;
                if (map.containsKey(k)) {
                    int j = map.get(k);
                    if ((i - j) % 2 == 0) ans = (i - j > ans) ? i - j : ans;//[j+1,i]区间0、1数量相等
                } else map.put(k, i);
            }
            return ans;
        }
    }
}