package StudyPlan.DP;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    static ArrayList<Integer> integers = new ArrayList<>();
    int[] arr = new int[8];

    public static void main(String[] args) {
        int n = 1;
        List<Integer> result = new ArrayList<>();
        while (n <= 7) {
            result.add(new Fibonacci().findFib(n++));
        }
        System.out.print(result);
    }

    public int findFib(int n) {
        if (arr[n] != 0) {
            return arr[n];
        }
        if (n <= 2) {
            return 1;
        } else {
            int i = findFib(n - 1) + findFib(n - 2);
            arr[n] = i;
            return i;
        }
    }
}
