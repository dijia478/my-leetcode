package cn.dijia478;

/**
 * 1295. 统计位数为偶数的数字
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数）
 * 345 是 3 位数字（位数为奇数）
 * 2 是 1 位数字（位数为奇数）
 * 6 是 1 位数字 位数为奇数）
 * 7896 是 4 位数字（位数为偶数）
 * 因此只有 12 和 7896 是位数为偶数的数字
 * 示例 2：
 * <p>
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 *
 * @author dijia478
 * @date 2020-09-03 17:44
 * @type 数组
 */
public class Code1295 {

    public static void main(String[] args) {
        int[] a = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers(a));
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            // 用 &1 来判断奇偶
            if ((String.valueOf(num).length() & 1) == 0) {
                count++;
            }
        }
        return count;
    }

}
