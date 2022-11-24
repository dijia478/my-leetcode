package cn.dijia478.string.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * <p>
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 * <p>
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: s = "aabb"
 * 输出: -1
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 只包含小写字母
 *
 * @author dijia478
 * @date 2022/11/24
 * @label 队列 哈希表 字符串 计数
 */
public class Code387 {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar2(s));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) > 1) {
                continue;
            }
            return i;
        }
        return -1;
    }

    public static int firstUniqChar1(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

}
