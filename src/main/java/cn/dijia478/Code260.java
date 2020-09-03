package cn.dijia478;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 260. 只出现一次的数字 III
 * <p>
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * <p>
 * 示例 :
 * <p>
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 * <p>
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * {@link Code137}
 *
 * @author dijia478
 * @date 2020-6-23 19:55
 */
public class Code260 {

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 3, 2, 5};
        System.out.println(JSON.toJSONString(singleNumber(a)));
    }

    public static int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, (map.get(num) == null ? 0 : map.get(num)) + 1);
        }

        byte a = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[a++] = entry.getKey();
            }
        }
        return result;
    }

}
