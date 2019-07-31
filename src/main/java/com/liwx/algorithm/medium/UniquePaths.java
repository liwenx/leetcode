package com.liwx.algorithm.medium;

/**
 * https://leetcode.com/problems/unique-paths/
 * @author liwenxing
 * @date 7/31/19 8:45 PM
 */
public class UniquePaths {
    public static void main(String[] args) {

    }
    public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for (int i = 0; i < m; i ++) {
            map[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            map[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
