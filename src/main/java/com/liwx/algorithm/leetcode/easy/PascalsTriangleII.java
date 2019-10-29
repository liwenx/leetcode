package com.liwx.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/pascals-triangle-ii/
 *
 * @author liwenxing
 * @date 10/29/19 8:17 PM
 */
public class PascalsTriangleII {
    public static void main(String[] args) {

    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0) {
            return list;
        }
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0,1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j+1));
            }
        }
        return list;
    }

}
