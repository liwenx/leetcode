package com.liwx.algorithm.leetcode.medium;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 *
 * @author liwenxing
 * @date 7/30/19 9:10 PM
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 3;
        int[][] r = generateMatrix(n);
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j++) {
                System.out.print(r[i][j] + ",");
            }
            System.out.println();
        }
    }

    /**
     * 按层输出
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int begin = 1;
        int[][] result = new int[n][n];
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                result[r1][c] = begin++;
            }
            for (int r = r1 + 1; r <= r2; r++) {
                result[r][c2] = begin++;
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    result[r2][c] = begin++;
                }
                for (int r = r2; r > r1; r--) {
                    result[r][c1] = begin++;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }
}
