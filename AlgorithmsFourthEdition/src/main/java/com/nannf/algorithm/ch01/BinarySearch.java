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

    public static int rankWithRecursive(int key, int[] a, int start, int end) {
        //截至条件
        if (start > end) {
            return -1;
        }
        // 转换成小问题
        int mid = start + (end - start) / 2;
        if (a[mid] == key) {
            return mid;
        }
        if (a[mid] < key) {
            return rankWithRecursive(key, a, mid + 1, end);
        } else {
            return rankWithRecursive(key, a, start, mid - 1);
        }
    }


    public static void main(String[] args) {
        int key = 3;
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(rank(key, a));

        System.out.println(rankWithRecursive(key, a, 0, a.length - 1));
    }
}
