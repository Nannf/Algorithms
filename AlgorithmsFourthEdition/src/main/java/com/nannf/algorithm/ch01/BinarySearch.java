package com.nannf.algorithm.ch01;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/10/16 16:37
 * @Description
 */
public class BinarySearch {

    public static int rank(int key, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int key = 3;
        int[] a= {1,2,3,4,5,6,7};
        System.out.println(rank(key,a));
    }
}
