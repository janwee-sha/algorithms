package BitOperation;

/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 * 数组中元素的范围为从 0到 10^9。
 * 数组的长度不超过 10^4。
 */
public class TotalHammingDistance {
    //time complexity:O(N),space complexity:O(1)
    public static class Solution1 {
        public int totalHammingDistance(int[] nums) {
            int ans = 0, n = nums.length;
            for (int i = 0; i < 30; i++) {
                int m = 0;
                for (int num : nums)
                    m += (num >> i) & 1;
                ans += m * (n - m);
            }
            return ans;
        }
    }
}
