package com.liwx.algorithm.medium;

/**
 * https://leetcode.com/problems/rotate-image/
 * @author liwenxing
 * @date 7/26/19 2:39 PM
 */
public class RotateImage {
    public static void main(String[] args) {

    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        //翻转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
