package cn.dijia478;

/**
 * 汉诺塔问题
 *
 * @author dijia478
 * @date 2020-09-11 14:06
 * @label 递归
 */
public class Hanoi {

    public static void main(String[] args) {
        hanoi(3, 'a', 'b', 'c');
    }

    /**
     * 借助B，从A到C
     *
     * @param n
     * @param A
     * @param B
     * @param C
     */
    public static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println(A + "->" + C);
            return;
        }
        // 如果n=1，那么要借助B，从A到C，第一步就是从A 到 B
        hanoi(n - 1, A, C, B);
        System.out.println( A + "->" + C);
        // 如果n=1，那么要借助B，从A到C，第二步就是从B 到 C
        hanoi(n - 1, B, A, C);
    }

}
