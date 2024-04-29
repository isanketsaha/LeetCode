package StudyPlan.String;


/*
*
*
* Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Example 1:

Input: s = "leetcode"
Output: 0
*
*
*
* */


import java.util.*;

public class UniqueCharacterInString {
    public static void main(String[] args) {
        UniqueCharacterInString inString = new UniqueCharacterInString();
        int leetcode = inString.firstUniqueChar("leetcode");
        System.out.println(leetcode);
    }

    public int firstUniqueChar(String s) {
        Set<Character> set = new LinkedHashSet<>();
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (!list.contains(c) && !set.add(c)) {
                set.remove(c);
                list.add(c);
            }
        }
        Optional<Character> first = set.stream().findFirst();

        return first.isPresent() ? s.indexOf(first.get()) : -1;

    }
}
