package com.liwx.algorithm.medium;

import com.liwx.algorithm.util.TreeNode;

/**
 * @author liwenxing
 * @date 2019/3/11 20:52
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    public static boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }

        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
