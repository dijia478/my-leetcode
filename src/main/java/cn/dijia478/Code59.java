package cn.dijia478;

import com.alibaba.fastjson.JSON;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author dijia478
 * @date 2020-09-03 18:40
 * @type 数组
 */
public class Code59 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                // left to right.
                mat[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                // top to bottom.
                mat[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                // right to left.
                mat[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                // bottom to top.
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }

}
