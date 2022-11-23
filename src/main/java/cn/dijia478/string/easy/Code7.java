package cn.dijia478.string.easy;

/**
 * 7. 整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 *
 * @author dijia478
 * @date 2022/11/23
 * @label 数学
 */
public class Code7 {

    public static void main(String[] args) {
        int x = 1234567899;
        int reverse = reverse(x);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int length = chars.length;

        int l = 0;
        if (x < 0) {
            l = 1;
        }
        int r = length - 1;
        while (l < r) {
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
        String s = new String(chars);
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
