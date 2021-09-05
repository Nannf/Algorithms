package com.nannf.exam.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/5 14:11
 * @Description 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得   a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 输入：nums = []
 * 输出：[]
 * 输入：nums = [0]
 * 输出：[]
 */
public class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果发现了，我们要怎么做？
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    // j得变成下一个不等于现在这个值的
                    int m = j + 1;
                    while (m < nums.length - 1 && nums[m] == nums[j]) {
                        m++;
                    }
                    j = m;

                    int n = k - 1;
                    while (n > 0 && nums[n] == nums[k]) {
                        n--;
                    }
                    k = n;
                    continue;
                }

                if (sum > 0) {
                    int n = k - 1;
                    while (n > 0 && nums[n] == nums[k]) {
                        n--;
                    }
                    k = n;
                    continue;
                }

                if (sum < 0) {
                    int m = j + 1;
                    while (m < nums.length - 1 && nums[m] == nums[j]) {
                        m++;
                    }
                    j = m;
                }
            }
        }
        return ans;
    }
}
