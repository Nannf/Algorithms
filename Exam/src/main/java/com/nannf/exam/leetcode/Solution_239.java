package com.nannf.exam.leetcode;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/5 8:25
 * @Description 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class Solution_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        // 0 -> 索引， 1-> 值
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 大顶堆，反过来减
                return o2[1] - o1[1];
            }
        });
        // 进行初始化
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{i, nums[i]});
        }
        ans[0] = queue.peek()[1];
        for (int i = 1; i < len - k + 1; i++) {
            queue.offer(new int[]{i+k-1,nums[i+k-1]});
            while (queue.peek()[0] < i) {
                queue.poll();
            }
            ans[i] = queue.peek()[1];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int k = 5;

        int[] ans = new Solution_239().maxSlidingWindow(nums,k);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
