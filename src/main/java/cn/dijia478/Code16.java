package cn.dijia478;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * <p>
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * {@link Code15}
 *
 * @author dijia478
 * @date 2020-6-24 10:35
 * @type 数组
 */
public class Code16 {

    public static void main(String[] args) {
        int[] a = {0, 1, 2};
        System.out.println(threeSumClosest(a, 3));
    }

    public static int threeSumClosest(int[] nums, int target) {
        // 双指针，先排序
        Arrays.sort(nums);

        // 要返回的结果
        int result = 0;
        // 初始化最小的差距值
        int minAbs = Integer.MAX_VALUE;
        // 遍历原数组
        for (int i = 0; i < nums.length - 2; i++) {
            // 去除重复值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 初始化双指针
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 去除重复值，并移动指针
                if (sum > target) {
                    while (j < k && nums[k] == nums[--k]) {}
                } else if (sum < target) {
                    while (j < k && nums[j] == nums[++j]) {}
                } else {
                    // 特殊情况，如果等于，直接返回
                    return sum;
                }

                // 判断差距值是否是已知最小
                int abs = Math.abs(sum - target);
                if (abs < minAbs) {
                    result = sum;
                    minAbs = abs;
                }
            }
        }
        return result;
    }

}
