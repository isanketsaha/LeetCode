package StudyPlan.Array;


/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/

import java.util.Arrays;
import java.util.Hashtable;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] ints = sum.twoSum(new int[]{2, 7, 11, 15}, 17);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> table = new Hashtable();
        for (int j = 0; j < nums.length; j++) {
            int i = target - nums[j];
            if (table.containsKey(i)) {
                return new int[]{table.get(i), j};
            } else {
                table.put(nums[j], j);
            }

        }
        return new int[]{};
    }
}
