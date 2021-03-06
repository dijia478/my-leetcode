package cn.dijia478;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p>
 * {@link Code78}
 *
 * @author dijia478
 * @date 2020-09-03 18:07
 * @label 数组 位运算 回溯算法
 */
public class MianShi0804 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(JSON.toJSONString(subsets(a)));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int bmp = (int)Math.pow(2, nums.length);
        // 从 nums.length 个 0 遍历到 nums.length 个 1
        for (int i = 0; i < bmp; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // 将每一位右移最低位，检测其是否为1
                if ((i >>> j & 1) == 1) {
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }

}
