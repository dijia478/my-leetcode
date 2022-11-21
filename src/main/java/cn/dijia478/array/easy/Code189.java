package cn.dijia478.array.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 189. 旋转数组
 * <p>
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *  
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 * @author dijia478
 * @date 2022/11/18
 * @label 数组 数学 双指针
 */
public class Code189 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        rotate1(nums, k);

        System.out.println(JSON.toJSONString(nums));
    }

    public static void rotate(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i < k; i++) {
            Integer integer = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(0, integer);
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }

    public static void rotate1(int[] nums, int k) {
        int length = nums.length;
        int[] temp = new int[length];
        // System.arraycopy(nums, 0, temp, 0, nums.length);
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }

    public static void rotate2(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - 1);//先反转全部的元素
        reverse(nums, 0, k - 1);//在反转前k个元素
        reverse(nums, k, length - 1);//接着反转剩余的
    }

    /**
     * 反转nums数组中[start,end]之间的元素
     *
     * @param nums
     * @param start
     * @param end
     */
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
