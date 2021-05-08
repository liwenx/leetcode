package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.TreeLinkNode;

/**
 * @author liwenxing
 * @date 9/23/19 9:08 PM
 */
public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {

    }
    public TreeLinkNode connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while (levelStart != null) {
                if (levelStart.left != null) {
                    currentChild.next = levelStart.left;
                    currentChild = currentChild.next;
                }
                if (root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                levelStart = levelStart.next;
            }
            levelStart = tempChild.next;
        }
        return root;
    }
}
