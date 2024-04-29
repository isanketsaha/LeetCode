package StudyPlan.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class DuplicateII {

    public static void main(String[] args) {
       System.out.print( new DuplicateII().containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length - 1; i++) {
                if (set.add(nums[i])) {
                    if (set.size() > k) {
                        set.remove(nums[i - k]);
                    }
                } else {
                    return true;
                }
            }

        return false;
    }
}
