package StudyPlan.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Threshold {

    public static void main(String[] args) {
        System.out.print(new Threshold().checkInclusion("adc", "dcda"));
    }

    public boolean checkInclusion(String s1, String s2) {
        char[] charArray = s1.toCharArray();
        Arrays.sort(charArray);
        s1 = String.valueOf(charArray);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String substring = s2.substring(i, i + s1.length());
            char[] charA = substring.toCharArray();
            Arrays.sort(charA);
            if(String.valueOf(charA).equals(s1))
                return true;
        }
        return false;
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            if ((sum / k) >= threshold) {
                result++;
            } else {
                System.out.println(arr[i]);
            }
            sum += arr[i];
            sum -= arr[i - k];
        }
        if ((sum / 3) >= threshold) {
            result++;
        }
        return result;
    }
}
