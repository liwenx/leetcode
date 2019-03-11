package com.liwx.algorithm.hard;

/**
 * @author liwenxing
 * @date 2019/1/14 18:34
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 */
public class SubstringWithConcatenationOfAllWords {
    static int a = 0;
    public static void main(String[] args) {
    foo(9);
        System.out.println(a);
    }

    public static int foo (int i) {
        a =a+1;
        if (i < 2) {
            return 1;
        } else {
            return foo(i-3) + foo(i-2) + 1;
        }
    }

}
