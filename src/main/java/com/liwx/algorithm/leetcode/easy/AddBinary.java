package com.liwx.algorithm.leetcode.easy;

/**
 *
 * https://leetcode.com/problems/add-binary/
 *
 * @author liwenxing
 * @date 8/1/19 4:10 PM
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        int sum;
        for (int i = a.length() -1, j = b.length() - 1; i >=0 || j >= 0; i--, j--) {
            sum = (i >= 0 ? (int) a.charAt(i) - 48 : 0) + (j >= 0 ? (int)b.charAt(j) - 48 : 0) + temp;
            sb.append(sum % 2);
            temp = sum / 2;
        }
        if (temp > 0) {
            sb.append(temp);
        }
        return sb.reverse().toString();
    }
}
