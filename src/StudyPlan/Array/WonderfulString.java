package StudyPlan.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WonderfulString {

    int[] lookup = new int[10];
    char[] words;

    public static void main(String[] args) {
        long l = new WonderfulString().wonderfulSubstrings("aba");
        System.out.println(l);
    }

    public long wonderfulSubstrings(String word) {
        this.words = word.toCharArray();
        return wonderfulSubstrings(0, 0);
    }

    public long wonderfulSubstrings(int start, int end) {
        int countOdd = 0;
        int sum = 0;
        if (start >= words.length) {
            return 0;
        } else {
            Arrays.fill(lookup, 0);
            for (int i = start; i <= end; i++) {
                lookup[words[i] - 'a'] += 1;
            }
            for (int i = 0; i < lookup.length && countOdd <= 1; i++) {
                if (lookup[i] == 1) {
                    ++countOdd;
                }
            }
            if (end == words.length - 1) {
                start += 1;
                end = start;
            } else {
                end += 1;
            }
            sum += ((countOdd > 1 ? 0 : 1) + wonderfulSubstrings(start, end));
            return sum;

        }
    }

}
