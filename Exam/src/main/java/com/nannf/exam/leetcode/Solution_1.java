package com.nannf.exam.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nannf
 * @version v1.0
 * @date 2021/9/5 14:04
 * @Description
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class Solution_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length ; i++) {
            int anotherValue = target - nums[i];
            if (map.containsKey(anotherValue)) {
                return new int[] {i,map.get(anotherValue)};
            }
            map.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }
}
