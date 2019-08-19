package com.liwx.algorithm.leetcode.medium;

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
        int[] arr =  {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }

    /**
     * my answer
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
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
        return maxarea;
    }
}
