package cn.dijia478;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 1313. 解压缩编码列表
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 * <p>
 * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 * <p>
 * 请你返回解压后的列表。
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 * 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,3]
 * 输出：[1,3,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 *
 * @author dijia478
 * @date 2020-09-03 17:52
 * @label 数组
 */
public class Code1313 {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3};
        System.out.println(JSON.toJSONString(decompressRLElist(a)));
    }

    public static int[] decompressRLElist(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                count = nums[i];
            } else {
                for (int j = 0; j < count; j++) {
                    list.add(nums[i]);
                }
                count = 0;
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
