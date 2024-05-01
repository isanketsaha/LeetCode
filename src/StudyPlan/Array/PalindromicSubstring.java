package StudyPlan.Array;

import java.util.Arrays;
import java.util.HashMap;

public class PalindromicSubstring {

    public static void main(String[] args) {
        String s = new PalindromicSubstring().longestPalindrome("a");
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        String result = "";
        HashMap<Character, Integer> lookup = new HashMap<>();
        for (int k = 0; k < charArray.length; k++) {
            lookup.put(charArray[k], k);
        }

        for (int k = 0; k < charArray.length; k++) {
            if (k <= lookup.get(charArray[k])
                    && checkPalindrom(charArray, k, lookup.get(charArray[k]))) {
                String s1 = new String(Arrays.copyOfRange(charArray, k, lookup.get(charArray[k]) + 1));
                if (s1.length() > result.length()) {
                    result = s1;
                }
            }
        }
        return result;
    }

    private boolean checkPalindrom(char[] chars, int i, int j) {
        while (i <= j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            ++i;
            --j;
        }
        return true;

    }
}
