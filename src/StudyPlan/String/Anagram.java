package StudyPlan.String;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        boolean anagram1 = anagram.isAnagram("anagran", "nagaram");
        System.out.println(anagram1);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        else {
            char[] alphabet = new char[26];
            for(char c : s.toCharArray()){
                alphabet[c-'a']++;
            }
            for(char p: t.toCharArray()){
                if(alphabet[p-'a'] == 0) return false;
                alphabet[p-'a']--;
            }
            return true;
        }

    }
}
