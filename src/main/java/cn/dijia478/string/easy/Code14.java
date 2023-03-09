package cn.dijia478.string.easy;

import java.util.HashSet;

/**
 * 14.最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * @author dijia478
 * @date 2023/3/9
 * @label 字典树 字符串
 */
public class Code14 {

    public static void main(String[] args) {
        // String[] strs = {"flower","flow","flight"};
        // String[] strs = {"dog","racecar","car"};
        String[] strs = {"ab", "a"};
        // String[] strs = {"ab", "ab", "ab"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= 200; i++) {
            for (int j = 0; j < strs.length; j++) {
                String str = strs[j];
                if (str.length() == 0) {
                    return "";
                }
                if (str.length() < i) {
                    return str;
                }
                String substring = str.substring(0, i);
                set.add(substring);
            }
            if (set.size() > 1) {
                return set.toArray(new String[0])[0].substring(0, i - 1);
            }
            set.clear();
        }
        return "";
    }
}
