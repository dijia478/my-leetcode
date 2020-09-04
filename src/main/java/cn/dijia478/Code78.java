package cn.dijia478;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
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
 * {@link MianShi0804}
 *
 * @author dijia478
 * @date 2020-09-03 17:36
 * @label 数组 位运算 回溯算法
 */
public class Code78 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(JSON.toJSONString(subsets(a)));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> subList = new ArrayList<>();
            for (List<Integer> curr : result) {
                ArrayList<Integer> arrayList = new ArrayList<>(curr);
                arrayList.add(num);
                subList.add(arrayList);
            }
            result.addAll(subList);
        }

        return result;
    }

}
