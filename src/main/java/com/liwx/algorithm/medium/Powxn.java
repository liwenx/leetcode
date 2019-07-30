package com.liwx.algorithm.medium;

/**
 * @author liwenxing
 * @date 7/26/19 4:43 PM
 */
public class Powxn {
    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        return (n%2 ==0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
