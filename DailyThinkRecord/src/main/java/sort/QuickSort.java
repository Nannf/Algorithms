package sort;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/17 22:41
 * @Description 快排
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {6,5,4,1,2,3};
        sort(a,6);
        for (int i : a) {
            System.out.println(i);
        }
    }


    public static void sort(int[] a, int len) {
        subSort(a, 0, len - 1);
    }

    // 来吧，喜闻乐见的递归
    // 我们定义subSort 函数是把数组a，在[start,end]区间的完全有序
    private static void subSort(int[] a, int start, int end) {
        // 递归终止条件，参见归并排序
        if (start >= end) {
            return;
        }

        // 快排的核心是分区，选择一个位置，把比这个值小的分为一组，然后比这个大的分为一组
        // 这个q的索引就是本次选择的位置实际应该在的位置
        int q = partition(a, start, end);
        // 缩小问题规模
        subSort(a, start, q - 1);
        subSort(a, q + 1, end);
    }

    private static int partition(int[] a, int start, int end) {
        // 怎么计算这个位置呢？
        // 这个位置的特点是，找到多少个比q小的
        int target = a[end];
        // 这个就是我们选择出来的位置
        int temp = 0;
        for (int i = start; i < end; i++) {
            if (a[i] <= target) {
                temp++;
            }
        }
        a[end] = a[temp];
        a[temp] = target;
        return temp;
    }
}
