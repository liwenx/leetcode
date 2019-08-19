package com.liwx.algorithm.leetcode.hard;

/**
 * @author liwenxing
 * @date 2018/6/25 23:31
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 */
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int s1 = 0, s2 = 0;
        //合并两个有序数组到一个有序数组
        for (int i = 0 ; i < nums3.length; i ++) {
        	if (s1 < nums1.length && s2 < nums2.length) {
        		if (nums1[s1] <= nums2[s2]) {
        			nums3[i] = nums1[s1++];
        		} else {
        			nums3[i] = nums2[s2++];
        		}
        	} else if (s1 < nums1.length) {
        		nums3[i] = nums1[s1++];
        	} else {
        		nums3[i] = nums2[s2++];
        	}
        }
    	double result = 0;
        if (nums3.length % 2 == 0) {
        	result = (double)(nums3[nums3.length/2 -1] + nums3[nums3.length/2]) /2;
        } else {
        	result = nums3[nums3.length/2];
        }   	
        return result;
    }
    public static void main(String[] args) {
    	int[] nums1 = {1,3};
    			int []nums2 = {2};
    	System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
