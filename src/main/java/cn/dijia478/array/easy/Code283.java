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
        moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == 0 && nums[slow] == 0) {
                continue;
            } else if (nums[fast] == 0 && nums[slow] != 0) {
                slow++;
            } else if (nums[fast] != 0 && nums[slow] == 0) {
                nums[slow++] = nums[fast];
                nums[fast] = 0;
            } else {
                slow++;
            }
        }
    }
}
