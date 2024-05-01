package StudyPlan.String;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrefixOfWord {

    public static void main(String[] args) {
        String s = new PrefixOfWord().reversePrefix("abcdefd", 'd');
        System.out.println(s);
    }

    public String reversePrefix(String word, char ch) {
        char[] charArray = word.toCharArray();
        final int[] chIndex = {IntStream.range(0, word.length())
                .filter(i -> word.charAt(i) == ch)
                .findFirst()
                .orElse(-1)};
        if (chIndex[0] == -1) {
            return word;
        } else {
            IntStream.iterate(0, x -> x + 1)
                    .takeWhile(i -> i <= chIndex[0])
                    .forEach(k -> {
                        char tmp = charArray[k];
                        charArray[k] = charArray[chIndex[0]];
                        charArray[chIndex[0]--] = tmp;
                    });
            return new String(charArray);
        }
    }


}
