package com.liwx.algorithm.leetcode.easy;

import com.liwx.algorithm.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author liwenxing
 * @date 8/27/19 9:39 PM
 */
public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {

    }

    /**
     * BFS solution
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<>();
        levelMaker(resultList, root, 0);
        return resultList;
    }
    public void levelMaker(List<List<Integer>> list, TreeNode root,  int level) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(0, new LinkedList<>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }

}
