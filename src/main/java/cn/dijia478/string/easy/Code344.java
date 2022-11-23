package cn.dijia478.string.easy;

import com.alibaba.fastjson.JSON;

/**
 * 344. 反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = ['h','e','l','l','o']
 * 输出：['o','l','l','e','h']
 * 示例 2：
 * <p>
 * 输入：s = ['H','a','n','n','a','h']
 * 输出：['h','a','n','n','a','H']
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 *
 * @author dijia478
 * @date 2022/11/23
 * @label 双指针 字符串
 */
public class Code344 {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(JSON.toJSONString(s));
    }

    public static void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

}
