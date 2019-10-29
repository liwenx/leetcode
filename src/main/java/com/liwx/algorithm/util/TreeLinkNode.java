package com.liwx.algorithm.util;

/**
 * @author liwenxing
 * @date 9/23/19 9:10 PM
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode() {}
    public TreeLinkNode(int val) {
        this.val = val;
    }

    public TreeLinkNode(int _val, TreeLinkNode _left, TreeLinkNode _right, TreeLinkNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
