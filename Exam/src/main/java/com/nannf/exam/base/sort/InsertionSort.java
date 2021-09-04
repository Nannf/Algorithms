package com.nannf.exam.base.sort;

/**
 * @author Nannf
 * @version v1.0
 * @Description 插入排序
 * @date 2021/9/4 17:21
 */
public class InsertionSort {
    public static int[] sort(int[] a, int len) {
        // 照例，外层是要循环的次数，从第二个开始，每次都跟前面已排序好的进行比较，找到合适的位置插入进去，故名，插入排序
        for (int i = 1; i < len; i++) {
            // 每次比较的双方是，i 和 它之前的所有的元素
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    int temp = a[i];
                    System.arraycopy(a, j, a, j + 1, i - j);
                    a[j] = temp;
                    break;
                }
            }
        }
        return a;
    }

    public static int[] sort_2(int[] a, int len) {
        // 照例，外层是要循环的次数，从第二个开始，每次都跟前面已排序好的进行比较，找到合适的位置插入进去，故名，插入排序
        for (int i = 1; i < len; i++) {
            int value = a[i];
            int j = i - 1;
            // 每次比较的双方是，i 和 它之前的所有的元素
            for (; j >= 0; j--) {
                // 如果发现在移动的过程中前一个比后一个大，就把那个数往后移
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
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
