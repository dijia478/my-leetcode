package cn.dijia478.sort;

import cn.hutool.core.util.ArrayUtil;
import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author dijia478
 * @date 2022/7/2
 */
public class ValidUtil {

    public static void main(String[] args) {
        int count = 100_0000;
        int maxSize = 100;
        int maxValue = 100;

        for (int i = 0; i < count; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);

            Code01_BubbleSort.bubbleSort(arr1);

            comparator(arr2);
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
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

}
