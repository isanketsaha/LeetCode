package StudyPlan.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LargestNumber {

    public static void main(String[] args) {
        String s = new LargestNumber().largestNumber(new int[]{3, 30, 34, 5, 9});
        System.out.println(s);
    }

    public String largestNumber(int[] nums) {
        return largestNumber(nums, 10);
    }

    public String largestNumber(int[] nums, int tens) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> Integer.valueOf(b.split("#")[0])
                .compareTo(Integer.valueOf(a.split("#")[0])));
        int[] lookup = new int[nums.length];
        for (int n = 0; n < nums.length; n++) {
            lookup[n] = (nums[n] <= tens - 1) ? nums[n] : (nums[n] / tens);
            pq.offer(((nums[n] <= tens - 1) ? nums[n] : (nums[n] / tens)) + "#" + n);
        }

        while (pq.size() > 2) {
            String fEle = pq.poll();
            String sEle = pq.poll();
            String[] split = fEle.split("#");
            if (Integer.valueOf(sEle.split("#")[0]) != Integer.valueOf(split[0])) {
                result.append(nums[Integer.valueOf(split[1])]);
                nums[Integer.valueOf(split[1])] = 0;
                pq.offer(sEle);
            } else {
                pq.offer(fEle);
                pq.offer(sEle);
                break;
            }
        }
        int[] array = Arrays.stream(nums)
                .filter(i -> i > 0)
                .toArray();
        if (array.length <= 2) {
            if (array.length == 1) {
                result.append(array[0]);
            } else {
                int n = array[0];
                int m = array[1];
                if (Math.abs(String.valueOf(n)
                        .length() - String.valueOf(m)
                        .length()) == 1
                        && String.valueOf(n)
                        .charAt(0) == String.valueOf(m)
                        .charAt(0)) {
                    int max = Math.max(n, m);
                    if ((max / 10) < (max % 10)) {
                        result.append(max);
                        result.append(Math.min(n, m));
                    } else {
                        result.append(Math.min(n, m));
                        result.append(max);
                    }
                } else {
                    if (((n < 10) ? n : (n / 10)) < ((m < 10) ? m : (m / 10))) {
                        result.append(array[1]);
                        result.append(array[0]);
                    } else {
                        result.append(array[0]);
                        result.append(array[1]);
                    }

                }

            }
        }

        if (pq.size() <= 2) {
            return result.toString();
        } else {
            result.append(largestNumber(array, tens * tens));
            return result.toString();
        }


    }
}
