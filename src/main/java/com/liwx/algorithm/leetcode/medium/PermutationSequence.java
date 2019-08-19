package com.liwx.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/permutation-sequence/
 *
 * @author liwenxing
 * @date 7/30/19 9:35 PM
 */
public class PermutationSequence {
    public static void main(String[] args) {

    }

    /**
     * https://segmentfault.com/a/1190000003766760
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int mod = 1;
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            mod *= i;
            candidates.add(i);
        }
        //减1方便整除
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            mod = mod / (n-i);
            // 得到当前应选数字的序数
            int first = k / mod;
            // 得到用于计算下一位的k
            k = k % mod;
            sb.append(candidates.get(first));
            // 在列表中移出该数字
            candidates.remove(first);
        }
        return sb.toString();
    }
}
