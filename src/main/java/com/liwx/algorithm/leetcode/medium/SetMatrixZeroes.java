package com.liwx.algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * @author liwenxing
 * @date 8/1/19 7:27 PM
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {

    }
    public void setZeroes(int[][] matrix) {
        Set<Integer> iSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    iSet.add(i);
                    jSet.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (iSet.contains(i) || jSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 用状态位就行了
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int rowNum = matrix.length, colNum = matrix[0].length;
        boolean[] rowArr = new boolean[rowNum];
        boolean[] colArr = new boolean[colNum];
        for(int i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                if(matrix[i][j] == 0) {
                    rowArr[i] = true;
                    colArr[j] = true;
                }
            }
        }
        for(int i = 0; i < rowNum; i++) {
            for(int j = 0; j < colNum; j++) {
                if(rowArr[i] || colArr[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
