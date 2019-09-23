package com.liwx.algorithm.util;

/**
 * @author liwenxing
 * @date 9/23/19 9:10 PM
 */
public class TreeeLinkNode {
    public int val;
    public TreeeLinkNode left;
    public TreeeLinkNode right;
    public TreeeLinkNode next;

    public TreeeLinkNode() {}

    public TreeeLinkNode(int _val, TreeeLinkNode _left, TreeeLinkNode _right, TreeeLinkNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
