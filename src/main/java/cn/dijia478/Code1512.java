package cn.dijia478;

/**
 * 1512. 好数对的数目
 * 给你一个整数数组 nums 。
 * <p>
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * <p>
 * 返回好数对的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * @author dijia478
 * @date 2020-09-03 15:16
 */
public class Code1512 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs(a));
    }

    // /**
    //  * 因为1 <= nums[i] <= 100，才可以这么玩
    //  * 用空间（一个数组）换时间
    //  *
    //  * @param nums
    //  * @return
    //  */
    // public static int numIdenticalPairs(int[] nums) {
    //     int sum = 0;
    //     // 初始化一个数组，里面的每一个位置，对应着该数字出现的次数
    //     int[] arr = new int[100];
    //     for (int num : nums) {
    //         // 取出num-1位置的值，即为num出现的次数，取完会在该位置上++
    //         sum += arr[num - 1]++;
    //     }
    //     return sum;
    // }

    public static int numIdenticalPairs(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    sum++;
                }
            }
        }
        return sum;
    }
    
}
