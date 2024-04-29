package StudyPlan.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        threeSum(nums, result, 0);
        return new ArrayList<>(result);
    }

    public void threeSum(int[] nums, Set<List<Integer>> result, int index) {

        if (index < nums.length / 2) {
            int i = 0, j = nums.length - 1;
            while (i >= 0 && j < nums.length && i < j && nums[i] + nums[index] <= 0) {
                if (i != index) {
                    if (nums[index] + nums[i] + nums[j] == 0) {
                        result.add(Arrays.asList(nums[index], nums[i], nums[j]));
                        ++i;
                    } else if (Math.abs(nums[i] + nums[index]) < nums[j]) {
                        --j;
                    } else {
                        ++i;
                    }
                } else {
                    ++i;
                }


            }
            threeSum(nums, result, ++index);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(lists);
    }

}
