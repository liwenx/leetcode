package com.liwx.algorithm.medium;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * @author liwenxing
 * @date 7/31/19 10:07 PM
 */
public class MinimumPathSum {
    public static void main(String[] args) {

    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] map = new int[m][n];
        map[0][0] = grid[0][0];
        for (int i = 1; i < m; i ++) {
            map[i][0] = map[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            map[0][j] = map[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = grid[i][j] + Math.min(map[i-1][j], map[i][j-1]);
            }
        }
        return map[m-1][n-1];
    }
}
