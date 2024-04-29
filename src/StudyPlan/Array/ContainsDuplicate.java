package StudyPlan.Array;

/* Given an integer array nums,
        return true if any value appears at least twice in the array, and return false if every element is distinct.*/

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        ContainsDuplicate duplicate = new ContainsDuplicate();
        boolean b = duplicate.containsDuplicate(new int[]{2, 5, 12, 3});
        System.out.println(b);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
