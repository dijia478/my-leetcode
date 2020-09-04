package cn.dijia478;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * {@link Code59}
 *
 * @author dijia478
 * @date 2020-09-04 10:36
 * @type 数组
 */
public class Code54 {

    public static void main(String[] args) {
        int[][] aa = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(aa));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int num = 1, tar = matrix[0].length * matrix.length;
        while (num <= tar) {
            for (int i = l; i <= r && num <= tar; i++) {
                result.add(matrix[t][i]);
                num++;
            }
            t++;
            for (int i = t; i <= b && num <= tar; i++) {
                result.add(matrix[i][r]);
                num++;
            }
            r--;
            for (int i = r; i >= l && num <= tar; i--) {
                result.add(matrix[b][i]);
                num++;
            }
            b--;
            for (int i = b; i >= t && num <= tar; i--) {
                result.add(matrix[i][l]);
                num++;
            }
            l++;
        }
        return result;
    }

}
