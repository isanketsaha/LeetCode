package StudyPlan.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberDisappeared {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] lookup = new boolean[nums.length];
        List<Integer> result = new ArrayList<>();
        for (int i : nums) {
            lookup[i] = true;
        }
        for(int i = 0 ;i < lookup.length; i++){
            if(!lookup[i]){
                result.add(i);
            }
        }
        return result;
    }
}
