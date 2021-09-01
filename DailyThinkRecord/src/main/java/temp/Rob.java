package temp;

/**
 * @author Nannf
 * @version v1.0
 * @Description 打家劫舍 dp的缘起之地
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * @date 2021/9/1 16:36
 */
public class Rob {
    // 每个屋子要么偷要么不偷
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int max = 0;
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
            max = Math.max(max, ans[i]);
        }

        return max;
    }
}
