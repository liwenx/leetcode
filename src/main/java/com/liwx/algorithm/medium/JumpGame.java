package com.liwx.algorithm.medium;

/**
 * https://leetcode.com/problems/jump-game/
 * @author liwenxing
 * @date 7/29/19 9:13 PM
 */
public class JumpGame {
    public static void main(String[] args) {

    }

    /**
     * 1.如果到达不了i点，那么一定到达不了i后面的点。
     */
    /**
     * https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode/
     */
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
