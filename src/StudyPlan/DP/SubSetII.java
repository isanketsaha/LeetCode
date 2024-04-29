package StudyPlan.DP;

import java.util.ArrayList;
import java.util.List;

public class SubSetII {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> lists = new SubSetII().subsetsWithDup(new int[]{0, 1});
        for (List<Integer> l : lists)
            System.out.println(l);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        subsetsWithDup(nums, new ArrayList<>(), 0);
        return result;
    }

    public void subsetsWithDup(int[] nums, List<Integer> list, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        subsetsWithDup(nums, list, index + 1);
        list.remove(list.size() - 1);
        subsetsWithDup(nums, list, index + 1);
    }
}
