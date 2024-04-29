package StudyPlan.String;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RansomNote {

    public static void main(String[] args) {
        RansomNote note = new RansomNote();
        boolean b = note.canConstruct("aa",
                "ab");
        System.out.println(b);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        } else {
            List<Character> removedChars = new ArrayList<>();
            List<Character> magazineChars = magazine.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            for (char ele : ransomNote.toCharArray()) {
                if (magazineChars.contains(ele)) {
                    magazineChars.remove((Character) ele);
                    removedChars.add(ele);
                }

            }
            return removedChars.size() == ransomNote.toCharArray().length;
        }
    }
}
