package StudyPlan.SlidingWindow;

import java.util.Arrays;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.print(new Solution().minSubArrayLen(15, new int[]{1,2,3,4,5}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        return minSubArrayLen(target, nums, nums.length - 1, 0);
    }

    public int minSubArrayLen(int target, int[] nums, int index, int result) {
        if (index >= 0) {
            if (target == 0) {
                return result;
            } else if (nums[index] <= target) {
               return minSubArrayLen(target - nums[index], nums, --index, ++result);
            } else {
                return  minSubArrayLen(target, nums, --index, result);
            }
        }
        return target == 0 ? result : 0;
    }
}
