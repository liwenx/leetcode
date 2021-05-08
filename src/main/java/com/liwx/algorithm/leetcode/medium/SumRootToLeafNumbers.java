package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.TreeNode;

/**
 * @author liwenxing
 * @date 2019/12/11 下午8:02
 */
public class SumRootToLeafNumbers {
    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSum(root, 0);
    }
    public int getSum (TreeNode tr, int before) {
        before = before * 10 + tr.val;
        if (tr.left == null && tr.right == null) {
            return before;
        }
        int res = 0;
        if (tr.left != null) {
            res += getSum(tr.left, before);
        }
        if (tr.right != null) {
            res+= getSum(tr.right, before);
        }
        return res;
    }
}
