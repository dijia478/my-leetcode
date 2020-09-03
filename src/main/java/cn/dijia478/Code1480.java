package cn.dijia478;

import com.alibaba.fastjson.JSON;

/**
 * 1480. 一维数组的动态和
 * <p>
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 *
 * @author dijia478
 * @date 2020-09-03 14:27
 */
public class Code1480 {

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 10, 1};
        System.out.println(JSON.toJSONString(runningSum(a)));
    }

    public static int[] runningSum(int[] nums) {
        // 要返回结果
        int[] result = new int[nums.length];
        // 初始化累加和
        int sum = 0;
        // 遍历原数组，将每一个元素累加到累加和上，并赋值给结果数组
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }
        // 返回结果
        return result;
    }

}
