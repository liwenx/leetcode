package com.liwx.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwenxing
 * @date 8/13/19 10:28 AM
 */
public class GrayCode {
    public static void main(String[] args) {

    }
    public List<Integer> grayCode(int n) {
        List<Integer> resList = new ArrayList<>();
        resList.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = resList.size() - 1; j >= 0; j--) {
                resList.add(head + resList.get(j));
            }
            head <<= 1;
        }
        return resList;
    }
}
