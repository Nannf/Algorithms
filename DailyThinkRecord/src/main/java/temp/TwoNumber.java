package temp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nannf
 * @version v1.0
 * @Description 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值
 * target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * @date 2021/9/1 11:41
 */
public class TwoNumber {

    // 方法一 暴力搜索
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        // 暴力列舉出所有的兩個組合
        for (int i = 0; i < nums.length - 1; i++) {
            // 暴力搜索在哪地方造成了浪费呢？
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    // 方法二： 排序之后，然后双指针查找
    // 这个会改变原来的下标索引，不太好
    public int[] twoSum_withSort(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                ans[0] = i;
                ans[1] = j;
                return ans;
            }
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }

    // 方法三： hash表
    public int[] twoSum_withHash(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int anotherNumber = target - nums[i];
            if (map.containsKey(anotherNumber) && map.get(anotherNumber) != i) {
                ans[0] = i;
                ans[1] = map.get(anotherNumber);
                return ans;
            }
        }
        return ans;
    }

    public int[] twoSum_withHash_OnePass(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int anotherNumber = target - nums[i];
            if (map.containsKey(anotherNumber)) {
                ans[0] = i;
                ans[1] = map.get(anotherNumber);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new TwoNumber().twoSum(nums, 9)));
    }

}
