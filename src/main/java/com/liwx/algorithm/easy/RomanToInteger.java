package com.liwx.algorithm.easy;

/**
 * @author liwenxing
 * @date 2018/11/4 20:00
 *
 * https://leetcode.com/problems/roman-to-integer/
 *
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }

    /**
     * my answer
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int[] values = {900,1000,400,500,90,100,40,50,9,10,4,5,1};
        String[] strs = {"CM","M","CD","D","XC","C","XL","L","IX","X","IV","V","I"};
        int num = 0;
        for (int i = 0; i < values.length; i ++) {
            while (s.indexOf(strs[i]) != -1) {
                num += values[i];
                s = s.replaceFirst(strs[i], "");
            }
        }
        return num;
    }

}
