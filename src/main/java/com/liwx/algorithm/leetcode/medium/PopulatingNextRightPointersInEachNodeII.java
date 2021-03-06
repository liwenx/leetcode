package com.liwx.algorithm.leetcode.medium;

import com.liwx.algorithm.leetcode.util.TreeLinkNode;

/**
 * @author liwenxing
 * @date 9/23/19 9:36 PM
 */
public class PopulatingNextRightPointersInEachNodeII {
    public static void main(String[] args) {

    }
    public TreeLinkNode connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        TreeLinkNode current = root;
        while (levelStart != null) {
            TreeLinkNode cur = levelStart;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next!= null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }

        return root;
    }
}
