package cn.dijia478;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * @author dijia478
 * @date 2020-09-07 17:06
 * @label 动态规划
 */
public class Code303 {

    private static int[] data;

    public static void main(String[] args) {
        int[] a = {-2, 0, 3, -5, 2, -1};
        NumArray(a);
        System.out.println(sumRange(2, 5));
    }

    public static void NumArray(int[] nums) {
        data = nums;
    }

    public static int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += data[k];
        }
        return sum;
    }
}
