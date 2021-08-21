package analyze;

/**
 * @author Nannf
 * @version v1.0
 * @Description 最大子串长度
 * @date 2021/8/21 12:30
 */
public class MaxSub {

    // 我们只要枚举所有的子串，取出其中的最大值即可
    // 如何枚举所有的子串呢？串总有开始和结束，所以我们用两个循环就可以完成枚举
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
        System.out.println(process(a, a.length));
    }
}
