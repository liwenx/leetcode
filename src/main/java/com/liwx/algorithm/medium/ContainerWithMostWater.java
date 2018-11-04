package com.liwx.algorithm.medium;

/**
 * @author liwenxing
 * @date 2018/11/4 15:05
 *
 * https://leetcode.com/problems/container-with-most-water/
 *
 *
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {

    }

    /**
     * my answer
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxarea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l ++;
            } else {
                r --;
            }
        }
        return -1;
    }
}
