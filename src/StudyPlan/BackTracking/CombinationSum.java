package StudyPlan.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    Set<List<Integer>> result = new HashSet<>();

    int[] candidates;
    int target = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        List<Integer> list = new ArrayList<>();
        combinationSum(list, 0, 0);
        return new ArrayList<>(result);
    }

    public void combinationSum(List<Integer> list, int index, int sum) {
        if (candidates.length - 1 < index || sum > target) {
            return;
        } else {
            if (sum == target) {
                result.add(new ArrayList(list));
            }
            list.add(candidates[index]);
            combinationSum(list, index, sum + candidates[index]);
            list.remove(list.size() - 1);
            combinationSum(list, index + 1, sum);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.print(lists);
    }
}
