package cn.dijia478;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,3,2]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * <p>
 * {@link Code260}
 *
 * @author dijia478
 * @date 2020-6-23 19:11
 */
public class Code137 {

    public static void main(String[] args) {
        // int[] a = {2, 2, 3, 2};
        int[] a = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(singleNumber(a));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, (map.get(num) == null ? 0 : map.get(num)) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;

        //        int ones = 0, twos = 0;
        //        for(int num : nums){
        //            ones = ones ^ num & ~ twos;
        //            twos = twos ^ num & ~ ones;
        //        }
        //        return ones;
    }

}
