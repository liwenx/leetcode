package com.liwx.algorithm.leetcode.medium;

/**
 *
 *https://leetcode.com/problems/search-a-2d-matrix/
 *
 * @author liwenxing
 * @date 8/1/19 7:49 PM
 */
public class SearchA2DMatrix {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        //二分查找
        int left = 0, right = m * n -1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) {
                return true;
            } else {
                if (target < pivotElement) {
                    right = pivotIdx - 1;
                } else left = pivotIdx + 1;
            }
        }
        return false;
    }
}
