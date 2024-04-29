package StudyPlan.Array;

import java.util.HashSet;

public class WordPattern {

    public static void main(String[] args) {
        boolean b = new WordPattern().wordPattern("syys", "a abc abc a");
        System.out.print(b);
    }

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        } else {
            HashSet<String> set = new HashSet<>();
            String[] lookup = new String[25];
            int index = 0;
            char[] charArray = pattern.toCharArray();
            while (index < words.length) {
                int i = charArray[index] - 'a';
                if (lookup[i] == null && !set.contains(words[index])) {
                    lookup[i] = words[index];
                    set.add(words[index]);
                    ++index;
                } else if (words[index].equals(lookup[i])) {
                    ++index;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
