package com.liwx.algorithm.medium;

/**
 *
 * https://leetcode.com/problems/word-search/
 *
 * @author liwenxing
 * @date 8/5/19 8:09 PM
 */
public class WordSearch {
    //是否已经走过了
    private boolean[][] marked;
    //上下左右行走方向
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    //行
    private int m;
    //列
    private int n;
    private String word;
    private char[][] board;

    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}};
        String word = "ba";
        WordSearch wordSearch = new WordSearch();
        boolean exist = wordSearch.exist(board, word);
        System.out.println(exist);
    }

    /**
     * 解法：https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }

        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs (int i, int j, int start) {
        if (start == word.length() -1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] =true;
            for (int k = 0; k < 4; k ++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            //状态重置
            marked[i][j] = false;
        }
        return false;
    }
    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
