package cn.dijia478.string.easy;

/**
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *  
 * <p>
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author dijia478
 * @date 2022/11/24
 * @label 哈希表 字符串 排序
 */
public class Code242 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagarama";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        int[] countt = new int[26];
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a']++;
        }
        for (int i = 0; i < chart.length; i++) {
            countt[chart[i] - 'a']++;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != countt[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        // 统计字符串s中的每个字符的数量
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 减去字符串t中的每个字符的数量
        for (int i = 0; i < t.length(); i++) {
            // 如果当前字符等于0，之前没出现过，直接返回false，
            if (count[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            count[t.charAt(i) - 'a']--;
        }
        return true;
    }

}
