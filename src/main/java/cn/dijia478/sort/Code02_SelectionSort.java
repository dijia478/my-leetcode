package cn.dijia478.sort;

import com.alibaba.fastjson.JSON;

/**
 * 2.选择排序
 *
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * 时间复杂度 O(n²)
 * 额外空间复杂度 O(1)
 *
 * @author dijia478
 * @date 2022/7/1
 */
public class Code02_SelectionSort {

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            // i ~ N-1 上找最小值的下标
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 交换位置
            swap(arr, i, minIndex);
        }


    }

    public static void swap(int[] arr, int i, int j) {
        // 数组的 i == j 时，用异或交换会出错
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 1, 7, -1, -1, 9, 5, 2, 4, 1};
        selectionSort(arr);
        System.out.println(JSON.toJSONString(arr));
    }

}
