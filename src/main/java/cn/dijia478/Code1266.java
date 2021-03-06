package cn.dijia478;

/**
 * 1266. 访问所有点的最小时间
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
 * <p>
 * 你可以按照下面的规则在平面上移动：
 * <p>
 * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[1,1],[3,4],[-1,0]]
 * 输出：7
 * 解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * 从 [1,1] 到 [3,4] 需要 3 秒
 * 从 [3,4] 到 [-1,0] 需要 4 秒
 * 一共需要 7 秒
 * 示例 2：
 * <p>
 * 输入：points = [[3,2],[-2,2]]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * points.length == n
 * 1 <= n <= 100
 * points[i].length == 2
 * -1000 <= points[i][0], points[i][1] <= 1000
 *
 * @author dijia478
 * @date 2020-09-03 17:05
 * @label 数组 几何
 */
public class Code1266 {

    public static void main(String[] args) {
        int[][] aa = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(aa));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] pointA = points[i];
            int[] pointB = points[i + 1];
            sum += Math.max(Math.abs(pointA[0] - pointB[0]), Math.abs(pointA[1] - pointB[1]));
        }
        return sum;
    }

}
