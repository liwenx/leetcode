package com.liwx.basic;

import java.util.Arrays;

/**
 * @author liwenxing
 * @date 2018/3/7 9:14
 */
public class QuickSortTest2 {
    public static void main(String[] args) {
        int[] arr = {52,78,99,2,5,18,80,23,66};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr,int sIndex, int eIndex){
        if (sIndex < eIndex) {
            int p = arr[sIndex], i = sIndex, k = eIndex;
            while (i < k){
                while (i < k && arr[k] >= p)
                    k--;
                if (i < k)
                    arr[i++] = arr[k];
                while (i < k && arr[i] < p)
                    i++;
                if(i < k)
                    arr[k--] = arr[i];
            }
            arr[i] = p;
            quickSort(arr, sIndex, i-1);
            quickSort(arr, i+1, eIndex);
        }
    }
}
