package cn.dijia478;

/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 *
 * @author dijia478
 * @date 2021/12/15
 * @label 数组 二分查找
 */
public class Code35 {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        int i = searchInsert2(a, 7);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        // 目标比第一个元素还小，在所有元素之前
        if (nums[0] > target) {
            return 0;
        }
        // 目标比最后一个元素还大，在所有元素之后
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            // 目标比当前元素大，比后一个元素小，在中间
            if (nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
            // 目标等于当前元素
            if (nums[i] == target) {
                return i;
            }
        }
        // 应该走不到这里才对
        return 0;
    }

    /**
     * 二分法解法，符合题目要求时间复杂度
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 这么写可以防止（a + b）超过int范围溢出了
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
