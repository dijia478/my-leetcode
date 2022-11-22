package cn.dijia478.array.easy;

import com.alibaba.fastjson.JSON;

/**
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * @author dijia478
 * @date 2022/11/21
 * @label 数组 双指针
 */
public class Code283 {

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        moveZeroes1(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0 && nums[slow] == 0) {
                fast++;
            } else if (nums[fast] != 0 && nums[slow] != 0) {
                fast++;
                slow++;
            } else if (nums[fast] == 0 && nums[slow] != 0) {
                fast++;
                slow++;
            } else {
                // nums[fast] != 0 && nums[slow] == 0
                nums[slow++] = nums[fast];
                nums[fast] = 0;
            }
        }
    }

    // =======================================

    public static void moveZeroes1(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            // 只要不为0就往前挪
            if (nums[j] != 0) {
                // i指向的值和j指向的值交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}
