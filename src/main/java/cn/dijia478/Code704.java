package cn.dijia478;

/**
 * 704. 二分查找
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 * @author dijia478
 * @date 2021/12/15
 * @label 数组 二分查找
 */
public class Code704 {

    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int search = search(a, 9);
        System.out.println(search);

    }

    public static int search(int[] nums, int target) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
                continue;
            }
            if (nums[mid] > target) {
                right = mid - 1;
                continue;
            }
            if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }
}
