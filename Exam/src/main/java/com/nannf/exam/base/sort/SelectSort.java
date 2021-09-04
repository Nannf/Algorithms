package com.nannf.exam.base.sort;

/**
 * @author Nannf
 * @version v1.0
 * @Description 选择排序
 * @date 2021/9/4 17:59
 */
public class SelectSort {
    public static int[] sort(int[] a, int len) {
        // 选择排序是每次找到最小的值，放到最开始
        for (int i = 0; i < len; i++) {
            // 这个是最小的值
            int min = a[i];
            // 这个是最小的值对应的下标
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            // 完成交换
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
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
