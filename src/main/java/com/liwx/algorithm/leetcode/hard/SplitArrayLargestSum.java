package com.liwx.algorithm.leetcode.hard;

/**
 *
 * https://leetcode.com/problems/split-array-largest-sum/
 *
 * @author liwenxing
 * @date 2019/12/11 下午2:22
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {

    }

    /**
     * 解题思路：
     * 由题意可知：子数组的最大值是有范围的，即在区间 [max(nums),sum(nums)][max(nums),sum(nums)] 之中。
     * 令 l=max(nums)，h=sum(nums)l=max(nums)，h=sum(nums)，mid=(l+h)/2mid=(l+h)/2，计算数组和最大值不大于mid对应的子数组个数 cnt(这个是关键！)
     * 如果 cnt>m，说明划分的子数组多了，即我们找到的 mid 偏小，故 l=mid+1l=mid+1；
     * 否则，说明划分的子数组少了，即 mid 偏大(或者正好就是目标值)，故 h=mid。
     *
     * https://leetcode-cn.com/problems/split-array-largest-sum/solution/er-fen-cha-zhao-by-coder233-2/
     *
     */
    public int splitArray(int[] nums, int m) {
        long l = nums[0], h = 0; //int类型不合适 因为int型相加可能会超过Integer.MAX_VALUE
        for (int i : nums) {
            h += i;
            l = l > i ? l : i;
        }
        //二分法
        while (l < h) {
            long mid = (l + h) / 2;
            long temp = 0;
            int cnt = 1;//初始数组个数为1
            for (int i : nums) {
                temp += i; //temp为当前子数组之和
                if (temp > mid) { //超过子数组最大值，分配个下一个子数组
                    temp = i;
                    ++cnt;//子数组+1
                }
            }
            if (cnt > m) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return (int) l;
    }

}
