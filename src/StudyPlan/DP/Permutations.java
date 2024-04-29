package StudyPlan.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Permutations implements Cloneable {

    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public static void main(String[] args) {
        List<List<Integer>> permute = new Permutations().permute(new int[]{0, 1});
        for (List<Integer> l : permute)
            System.out.println(l);

    }

    public List<List<Integer>> permute(int[] nums) {
        Optional<String> test = Optional.of("test");
        Optional<String> s = test.map(String::toUpperCase).or(() -> Optional.of(""));
        Optional
                .of("string")
                .map(k -> Optional.of("STRING"));
        this.nums = nums;
        permute(new ArrayList<>(), 0);
        return result;
    }

    public void permute(List<Integer> list, int index) {
        if (list.size() == nums.length) {
            result.add(list);
            return;
        }
        for (int i = index + 1; i < nums.length - 1; i++) {
            permute(list, i);
            list.add(nums[i + 1]);
            permute(list, i);
            list.remove(list.size() - 1);
            permute(list, i);
        }

    }
}
