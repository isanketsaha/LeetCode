package StudyPlan.Array;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

*/

public class MaximumSubArray {

    public static void main(String[] args) {
        MaximumSubArray subArray = new MaximumSubArray();
        int i = subArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int largestSum = Integer.MIN_VALUE;
        int currentNum = 0;
        for (int num : nums) {
            currentNum = Math.max(num, currentNum + num);
            if (largestSum < currentNum) {
                largestSum = currentNum;
            }
        }
        return largestSum;
    }
}
