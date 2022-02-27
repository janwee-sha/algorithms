package bitoperation;

public class IsPowerOfFour {
    public interface Solution {
        boolean isPowerOfFour(int n);
    }

    //time complexity:O(1),space complexity:O(1)
    public static class Solution1 implements Solution {
        public boolean isPowerOfFour(int n) {
            for (int i = 0; i < 31; i += 2) {
                if (n == 1 << i) return true;
            }
            return false;
        }
    }

    //time complexity:O(1),space complexity:O(1)
    public static class Solution2 implements Solution {
        public boolean isPowerOfFour(int n) {
            return n % 3 == 1 && (n & (n - 1)) == 0;
        }
    }
}
