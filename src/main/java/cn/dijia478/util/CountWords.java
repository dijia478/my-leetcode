package cn.dijia478.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 闲来无事，练习下正则和io，写个小程序，统计一篇英文文档里，所有单词出现的次数
 * 程序员根据这个来背单词，效率会更高一些吧
 *
 * @author dijia478
 * @date 2020-10-12 14:42
 */
public class CountWords {

    /** 大小驼峰匹配 */
    private static final Pattern PATTERN = Pattern.compile("[A-Z]?[a-z]+");

    /** 要统计的英文文档 */
    private static final String FILE = "d:\\English.txt";

    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>(1 << 15);
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            String[] lineWords;
            while ((line = br.readLine()) != null) {
                // 按非字母字符进行分割，分割出来的就是一个个单词（结果会有空字符串）
                lineWords = line.split("[^a-zA-Z]+");

                for (String lineWord : lineWords) {
                    if (lineWord.isEmpty()) {
                        continue;
                    }
                    // 大小驼峰类单词，把驼峰拆开统计
                    Matcher matcher = PATTERN.matcher(lineWord);
                    while (matcher.find()) {
                        String lowerCase = matcher.group(0).toLowerCase();
                        if (map.containsKey(lowerCase)) {
                            map.put(lowerCase, map.get(lowerCase) + 1);
                        } else {
                            map.put(lowerCase, 1);
                        }
                    }
                }
            }
        }

        // 按出现频率倒序排序
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // 控制台打印结果
        list.forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
    }

}