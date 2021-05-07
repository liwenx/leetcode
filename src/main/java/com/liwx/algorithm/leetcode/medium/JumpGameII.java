package com.liwx.algorithm.leetcode.medium;

/**
 *
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * @author liwenxing
 * @date 2021/5/7 下午1:47
 */
public class JumpGameII {


    public int jump2(int[] nums) {
        int length = nums.length;
        //上次跳跃可达范围右边界（下次的最右起跳点)
        int end = 0;
        //目前能跳到的最远位置
        int maxPosition = 0;
        //跳跃次数
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            //这句话很关键哦
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //到达上次跳跃能到达的右边界了
            if (i == end) {
                // 目前能跳到的最远位置变成了下次起跳位置的右边界
                end = maxPosition;
                // 进入下一次跳跃
                steps++;

            }
        }
        return steps;
    }
}
