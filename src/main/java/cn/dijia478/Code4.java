package cn.dijia478;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author dijia478
 * @date 2020-09-03 17:20
 * @type 数组
 */
public class Code4 {

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2};
        System.out.println(findMedianSortedArrays(a,b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 初始化目标数组
        int[] a = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            a[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            a[nums1.length + i] = nums2[i];
        }
        // 排序，求中位数
        Arrays.sort(a);
        if (a.length % 2 == 0) {
            int x = a[a.length / 2 - 1];
            int y = a[a.length / 2];
            return (x + y) * 1.0 / 2;
        } else {
            return a[(a.length - 1) / 2] * 1.0;
        }
    }

}
