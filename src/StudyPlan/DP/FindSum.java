package StudyPlan.DP;

import StudyPlan.SlidingWindow.Solution;

import java.util.ArrayList;
import java.util.List;

public class FindSum {

    int[] array;

    public static void main(String[] args) {
        new FindSum().solution(new int[]{5, 3, 4, 7}, 10);
    }

    void solution(int[] array, int target) {
        this.array = array;
        boolean solution = solution(target, -1);
        System.out.print(solution);
    }

    boolean solution(int target, int index) {
        if (target == 0) {
            return true;
        } else if (target < 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                continue;
            }
            if (solution(target - array[i], i)) {
                return true;
            }
        }
        return false;
    }
}
