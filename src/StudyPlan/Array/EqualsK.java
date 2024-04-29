package StudyPlan.Array;

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 */
public class EqualsK {

    int count = 0;

    int k;

    public static void main(String[] args) {
        int i = new EqualsK().subarraySum(new int[]{1}, 1);
        System.out.print(i);
    }

    public int subarraySum(int[] nums, int k) {
        this.k = k;
        subarraySum(nums, 0, 0);
        return count;

    }

    public void subarraySum(int[] nums, int sum, int index) {
        if (index == nums.length) {
            if (sum == k) {
                ++count;
            }
            return;
        } else {
            if (sum + nums[index] == k || sum == k) {
                ++count;
                subarraySum(nums, sum != k ? 0 : nums[index], ++index);
            } else if (sum + nums[index] < k) {
                subarraySum(nums, sum + nums[index], ++index);
            } else {
                subarraySum(nums, nums[index], ++index);
            }
        }
    }
}
