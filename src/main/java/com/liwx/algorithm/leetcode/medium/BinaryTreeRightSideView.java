package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.TreeNode;

import java.util.*;

/**
 *  二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * @author liwenxing
 * @date 2021/5/6 上午11:00
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {

    }

    /**
     * 深度优先
     * @param root
     * @return
     */
    public List<Integer> rightSideViewDepth(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (node != null) {
                //维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }
        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        return rightView;
    }

    /**
     * ----------------------------------------------/
     */
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideViewDfs(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        //depth ==res.size()表示是第一次访问到哦
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth ++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }

    /**
     * ----------------------------------------------\
     */

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();
            if (node != null) {
                //维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);
                //由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                rightmostValueAtDepth.put(depth, node.val);
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        return rightView;
    }


}
