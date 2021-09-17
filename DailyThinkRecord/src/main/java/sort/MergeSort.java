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


    public static void sort(int[] a, int len) {
        subSort(a, 0, len - 1);
    }

    private static void subSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        subSort(a, start, mid);
        subSort(a, mid + 1, end);
    }
}
