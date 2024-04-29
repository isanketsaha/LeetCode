package StudyPlan.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreePalindrome {
    Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        int i = new ThreePalindrome().countPalindromicSubsequence("aabca");
        System.out.print(i);
    }

    public int countPalindromicSubsequence(String s) {
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, -1);
        int curr;
        for (int i = 0; i < s.length(); i++) {
            curr = s.charAt(i) - 'a';
            if (left[curr] == - 1) {
                left[curr] = i;
            }
            right[curr] = i;
        }
        int ans = 0;
        boolean [] count;
        for (int i = 0; i < 26; i++) {
            if (left[i] == -1) {
                continue;
            }
            count = new boolean[26];
            for (int j = left[i] + 1; j < right[i]; j++) {
                if(!count[s.charAt(j)-'a']){
                    count[s.charAt(j)-'a'] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
