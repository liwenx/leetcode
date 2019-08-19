package com.liwx.algorithm.leetcode.medium;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * @author liwenxing
 * @date 7/31/19 9:54 PM
 */
public class UniquePathsII {
    public static void main(String[] args) {

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Integer[][] map = new Integer[m][n];
        map[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; i ++) {
            map[i][0] = obstacleGrid[i][0] == 1 ? 0 :map[i-1][0];
        }
        for (int j = 1; j < n; j++) {
            map[0][j] = obstacleGrid[0][j] == 1 ? 0 : map[0][j-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = obstacleGrid[i][j] == 1 ? 0 : map[i-1][j] + map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
