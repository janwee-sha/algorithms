package Cases;

public class IsPowerOfTwo {
    public interface Solution {
        boolean isPowerOfTwo(int n);
    }

    //time complexity:O(1),space complexity:O(1).
    //if n is a power of 2,n is a positive integer and n&(n-1) is 0
    public static class Solution1 implements Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }

    //time complexity:O(1),space complexity:O(1).
    //if n is a power of 2,n is a positive integer and n&(-n) is n
    public static class Solution2 implements Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (-n)) == n;
        }
    }

    //time complexity:O(1),space complexity:O(1).
    //if n is a power of 2,n is a positive integer and a divisor of 2^31
    public static class Solution3 implements Solution {
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (1 << 30) % n == 0;
        }
    }
}