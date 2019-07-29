package com.liwx.algorithm.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * @author liwenxing
 * @date 7/29/19 8:38 PM
 */
public class SpiralMatrix {
    public static void main(String[] args) {

    }

    /**
     * 解法：按层输出
     * https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode/
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();
        if (matrix.length == 0) {
            return resList;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                resList.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                resList.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    resList.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    resList.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return resList;
    }
}
