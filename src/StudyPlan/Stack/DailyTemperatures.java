package StudyPlan.Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] ints = dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }


    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(temperatures[0]);
        for (int i = 1; i < temperatures.length; i++) {
            int index = i;
            while (!stack.isEmpty() && stack.peek() < temperatures[i] && index > 0) {
                index -= 1;
                if(res[index]==0){
                res[index] = i - index;
                stack.pop();
                }
            }

            if (stack.isEmpty() || stack.peek() > temperatures[i]) {
                stack.push(temperatures[i]);
            }

        }
        return res;
    }
}
