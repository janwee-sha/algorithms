package Cases;

/**
 * 实现一个阿拉伯数字转中文的函数
 */
public class ArabicToChinese {
    private static final int[] NUMS = new int[]{100_000_000, 10_000, 1000, 100, 10};
    private static final char[] UNITS = new char[]{'亿', '万', '千', '百', '十'};
    private static final char[] AMOUNTS = new char[]{'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};


    public String arabicToChinese(int num) {
        if (num == 0) return String.valueOf(AMOUNTS[num]);
        StringBuilder sb = new StringBuilder();
        boolean zero = false;
        for (int i = 0; i <= NUMS.length && num > 0; i++) {
            if (i < NUMS.length) {
                int amount = num / NUMS[i];
                if (amount == 0) {
                    if (zero) {
                        sb.append(AMOUNTS[0]);
                        zero = false;
                    }
                    continue;
                }
                sb.append(arabicToChinese(amount)).append(UNITS[i]);
                num %= NUMS[i];
                zero = true;
            } else sb.append(AMOUNTS[num]);
        }
        return sb.toString();
    }
}
