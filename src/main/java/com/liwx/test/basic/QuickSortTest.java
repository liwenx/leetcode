package com.liwx.test.basic;

import java.util.Arrays;

/**
 * @author liwenxing
 * @date 2018/3/6 23:49
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] a = new int[]{2,1,6,7,8,5,3,5};
        quickSort(a,0,a.length -1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int begin, int end){
        int tbegin = begin, tend = end;
        //将第一个值作为排序的分界值
        int pivot = a[begin];
        while (tbegin < tend) {
            while(tbegin < tend && a[tend] >= pivot) {
                --tend;
            }
            a[tbegin] = a[tend];
            while(tbegin < tend && a[tbegin] <= pivot){
                ++begin;
            }
            a[tend] = a[tbegin];
        }

        a[tbegin] = pivot;
        if(begin <tend){
            quickSort(a,begin, tend - 1);
        }
        if(tbegin < end){
            quickSort(a, tbegin + 1, end);
        }
    }
}
