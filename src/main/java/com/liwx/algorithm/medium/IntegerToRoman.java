package com.liwx.algorithm.medium;

/**
 * @author liwenxing
 * @date 2018/11/4 18:56
 * <p>
 * https://leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    /**
     * my answer
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {

        StringBuilder roman = new StringBuilder();
        int m = 0;
        m = num / 1000;
        if (m > 0) {
            for (int i = 0; i < m; i++) {
                roman.append("M");
            }
        }
        num %= 1000;

        m = num / 500;
        if (m > 0) {
            if (num / 900 == 1) {
                roman.append("CM");
                num %= 900;
            } else {
                roman.append("D");
                num %= 500;
            }
        } else {
            num %= 900;
        }

        m = num / 100;
        if (m > 0) {
            if (m == 4) {
                roman.append("CD");
            } else {
                for (int i = 0; i < m; i++) {
                    roman.append("C");
                }
            }
        }
        num %= 100;

        m = num / 50;

        if (m > 0) {
            if (num / 90 == 1) {
                roman.append("XC");
                num %= 90;
            } else {
                roman.append("L");
                num %= 50;
            }
        } else {
            num %= 50;
        }

        m = num / 10;
        if (m > 0) {
            if (m == 4) {
                roman.append("XL");
            } else {
                for (int i = 0; i < m; i++) {
                    roman.append("X");
                }
            }
        }
        num %= 10;

        m = num / 5;
        if (m > 0) {
            if (num / 9 == 1) {
                roman.append("IX");
                num %= 9;
            } else {
                roman.append("V");
                num %= 5;
            }
        } else {
            num %= 5;
        }

        if (num > 0) {
            if (num == 4) {
                roman.append("IV");
            } else {
                for (int i = 0; i < num; i++) {
                    roman.append("I");
                }
            }
        }
        return roman.toString();
    }

    /**
     * 参考答案1
     */
    public static String intToRoman1 (int num){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
