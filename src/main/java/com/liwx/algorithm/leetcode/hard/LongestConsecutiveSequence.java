package com.liwx.algorithm.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * @author liwenxing
 * @date 2019/12/11 下午7:31
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int i : nums) {
            numSet.add(i);
        }
        int longestStreak = 0;
        for (int i : numSet) {
            if (!numSet.contains(i-1)) { //它前一个没有才开始算 如果它前一个有，就会被别的算进去，没必要再算了
                int currNum = i;
                int currentStreak = 1;
                while (numSet.contains(currNum+1)) {
                    currNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
