package cn.dijia478;

/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * @author dijia478
 * @date 2020-6-23 16:52
 */
public class Code67 {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        final StringBuilder result = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1, next = 0; i >= 0 || j >= 0 || next != 0; i--, j--) {
            int sum = next;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            result.append(sum % 2);
            next = sum / 2;
        }
        return result.reverse().toString();
    }

}
