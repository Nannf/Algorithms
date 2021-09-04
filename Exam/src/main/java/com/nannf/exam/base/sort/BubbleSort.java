package com.nannf.exam.base.sort;

/**
 * @author Nannf
 * @version v1.0
 * @Description 冒泡排序
 * @date 2021/9/4 8:08
 */
public class BubbleSort {

    public static int[] sort(int[] a, int len) {
        // 每次循环都找到未排序的最大值，需要找 len -1次
        for (int i = 0; i < len - 1; i++) {
            boolean flag = false;
            // 每次都是從第一個開始找起，需要找多少次呢
            // 第一次 5次
            for (int j = 0; j < len - (i + 1); j++) {
                // 每次都是从0开始，相邻的两个元素对比
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 1, 2, 3};
        for (int i : sort(a, 6)) {
            System.out.println(i);
        }
    }
}
