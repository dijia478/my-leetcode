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
        int max = Math.max(a.length(), b.length());
        a = getString(a, max);
        b = getString(b, max);

        StringBuilder sb = new StringBuilder();
        int next = 0;
        for (int i = max - 1; i >= 0; i--) {
            int aint = Integer.parseInt(a.charAt(i) + "");
            int bint = Integer.parseInt(b.charAt(i) + "");

            int sum = aint + bint + next;
            if (sum > 1) {
                next = 1;
            } else {
                next = 0;
            }
            if (sum == 0) {
                sb.append("0");
            } else if (sum == 1) {
                sb.append("1");
            } else if (sum == 2) {
                sb.append("0");
            } else if (sum == 3) {
                sb.append("1");
            }
        }
        if (next == 1) {
            sb.append("1");
        }
        sb.reverse();
        return sb.toString();
    }

    private static String getString(String a, int max) {
        if (a.length() < max) {
            StringBuilder asb = new StringBuilder(a);
            for (int i = 0; i < max - a.length(); i++) {
                asb.insert(0, "0");
            }
            a = asb.toString();
        }
        return a;
    }

}
