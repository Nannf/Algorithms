package analyze;

/**
 * @author Nannf
 * @version v1.0
 * @Description 最大子串长度
 * @date 2021/8/21 12:30
 */
public class MaxSub {


    // 相较于process我们发现，我们的时间复杂度来到的n^3
    // 因为蛮力的算法，需要罗列出所有的子串，所以我们至少需要两重循环
    // 但是第三层的循环是否可以避免呢？
    // 第三层循环做了什么事情，我们发现，它把固定之后的节点的两端的和加了一遍
    // 但是我们发现，对一个子串的头被固定的场景来说，子串的尾部是逐渐往后的
    // 这意味着，我移动尾部的时候，不用每次都重复计算
    private static int process2(int[] a, int len) {
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += a[j];
                ans = Math.max(sum,ans);
            }
        }
        return ans;
    }

    // 我们只要枚举所有的子串，取出其中的最大值即可
    // 如何枚举所有的子串呢？串总有开始和结束，所以我们用两个循环就可以完成枚举
    // 再开一个循环来
    private static int process(int[] a, int len) {
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += a[k];
                }
                ans = Math.max(sum,ans);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] a = {-2, 11, -4, 13, -5, -2};
        System.out.println(process2(a, a.length));
    }
}
