package cn.dijia478;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * @author dijia478
 * @date 2022/7/19
 */
public class Code9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }

    public static boolean isPalindrome(int x) {
        // 负数不是回文数
        if (x < 0) {
            return false;
        }
        // 个位数是回文数
        if (x < 10) {
            return true;
        }
        // 10的整倍数不是回文数
        if (x % 10 == 0) {
            return false;
        }

        String value = String.valueOf(x);
        int j;
        if (value.length() % 2 == 0) {
            j = value.length() / 2;
        } else {
            j = (value.length() - 1) / 2;
        }
        for (int i = 0; i < j; i++) {
            if (value.charAt(i) == value.charAt(value.length() - 1 - i)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
