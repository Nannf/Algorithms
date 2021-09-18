package sort;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/17 22:43
 * @Description 归并排序
 */
public class MergeSort {

    /**
     * // 归并排序算法, A是数组，n表示数组大小
     * merge_sort(A, n) {
     * merge_sort_c(A, 0, n-1)
     * }
     * <p>
     * // 递归调用函数
     * merge_sort_c(A, p, r) {
     * // 递归终止条件
     * if p >= r  then return
     * <p>
     * // 取p到r之间的中间位置q
     * q = (p+r) / 2
     * // 分治递归
     * merge_sort_c(A, p, q)
     * merge_sort_c(A, q+1, r)
     * // 将A[p...q]和A[q+1...r]合并为A[p...r]
     * merge(A[p...r], A[p...q], A[q+1...r])
     * }
     */

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 1, 2, 3};
        sort(a, 6);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sort(int[] a, int len) {
        subSort(a, 0, len - 1);
    }

    // 递归的绝大多数工作就是在给出递归函数的定义
    // 对本例而言，这个定义就是对数组a中的start 和 end 进行排序，我们对外给出了这个申明
    private static void subSort(int[] a, int start, int end) {
        // 照例给出终止条件，终止条件的含义就是，当start == end 的时候，天然有序； 当 start > end 的时候，此时已然不合法的状态。
        // 这就是终止状态，一般一个合理的子问题最后都会变成一个数字
        if (start >= end) {
            return;
        }
        // 然后是如何拆分子问题
        int mid = (start + end) / 2;
        // 我把左边的排有序了
        subSort(a, start, mid);
        // 我把右边的排有序了
        subSort(a, mid + 1, end);
        // 合并左右有序的，那么就全有序了
        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        // 这个函数就是假设 a[start,mid]和a[mid+1,end]分别有序，然后使 a[start,end]有序
        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid + 1;

        int t = 0;

        while (i <= mid && j <= end) {
            if (a[i] <= a[j]) {
                temp[t++] = a[i++];
            } else {
                temp[t++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = a[i++];
        }

        while (j <= end) {
            temp[t++] = a[j++];
        }

        t = 0;
        for (int m = start; m <= end; m++) {
            a[m] = temp[t++];
        }
    }
}

