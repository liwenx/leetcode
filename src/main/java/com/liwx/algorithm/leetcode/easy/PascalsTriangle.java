package com.liwx.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwenxing
 * @date 2019/10/27 18:49
 *
 * https://leetcode.com/problems/pascals-triangle/
 *
 */
public class PascalsTriangle {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0,1);
            for (int j = 1; j < row.size() -1; j ++) {
                row.set(j, row.get(j) + row.get(j+1));
            }
            result.add(new ArrayList<>(row));
        }
        return result;
    }
}
