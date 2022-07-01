package cn.dijia478.sort;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 1.冒泡排序
 *
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * 时间复杂度 O(n²)
 * 额外空间复杂度 O(1)
 *
 * @author dijia478
 * @date 2022/7/1
 */
public class Code01_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int count = 100_0000;
        int maxSize = 100;
        int maxValue = 100;

        for (int i = 0; i < count; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            bubbleSort(arr1);
            Arrays.sort(arr2);
            if (!ArrayUtil.equals(arr1, arr2)) {
                System.out.println("源数组：" + JSON.toJSONString(arr3));
                System.out.println("期望结果：" + JSON.toJSONString(arr2));
                System.out.println("实际结果：" + JSON.toJSONString(arr1));
                throw new RuntimeException("排序算法出错！");
            }
        }
        System.out.println("Nice！排序算法没问题！");
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)((maxValue * Math.random()));
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }

}
