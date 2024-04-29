package StudyPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class MicroTest {


    public static void main(String[] args) {
        MicroTest microTest = new MicroTest();
        System.out.println(microTest.solution("CBACDDCAAB"));
    }

    public String solution(String S) {
        Stack<Character> stack = new Stack<>();
        charArray = S.toCharArray();
        return solution(' ', 0);
    }

    char[] lookup = new char[]{'A', 'A', 'C', 'C'};
    char[] charArray;
    List<Character> result = new ArrayList<>();

    public String solution(Character prev, int index) {

        if (charArray.length == index) {
            return result.toString();
        } else {
            if (index < 1 || result.size() == 0) {
                result.add(charArray[index]);
                return solution(charArray[index], ++index);
            } else {
                int indexOne = prev - 'A';
                int indexSec = charArray[index] - 'A';
                if (indexOne != indexSec && lookup[indexOne] == lookup[indexSec]) {
                    result.remove(result.size() - 1);
                    return solution(result.size() > 0 ? result.get(result.size() - 1) : ' ', ++index);
                } else {
                    result.add(charArray[index]);
                    return solution(charArray[index], ++index);
                }
            }
        }
    }


    public String solution(int A, int B, int C) {
        StringBuilder result = new StringBuilder();
        int[] count = {A, B, C};
        int total = A + B + C;
        int lastChar = -1;

        for (int i = 0; i < total; i++) {
            boolean found = false;
            for (int j = 0; j < 3; j++) {
                if (count[j] > 0 && j != lastChar) {
                    // Append only if it won't form three in a row or if it's a different character.
                    if (result.length() < 2 || result.charAt(result.length() - 1) != j + 'a'
                            || result.charAt(result.length() - 2) != j + 'a') {
                        result.append((char) (j + 'a'));
                        count[j]--;
                        lastChar = j;
                        found = true;
                        break;
                    }
                }
            }

            // If no character was appended, break the loop to avoid infinite loop.
            if (!found) break;
        }
        return result.toString();
    }


//    public String solutionOne(int A, int B, int C, StringBuilder result) {
//
//        if (A == 0 && B == 0 && C == 0) {
//            return result.toString();
//        } else {
//
//            if (result.length() <= 2) {
//
//                if (A < B && C == 0 && (A == B / A - 1)) {
//                    result.append('b');
//                    solutionOne(A, --B, C, result);
//                } else {
//                    result.append('a');
//                    solutionOne(--A, B, C, result);
//                }
//
//            } else {
//                int length = result.length();
//                char last = result.charAt(length - 1);
//                char secLast = result.charAt(length - 1);
//
//                if (last == secLast) {
//                    if (last == 'a') {
//
//                    }
//                    if (last == 'b') {
//
//                    }
//                    if (last == 'c') {
//
//                    }
//                } else {
//                    if (last == 'a' && A > 0) {
//                        result.append('a');
//                        solutionOne(--A, B, C, result);
//                    }
//                    if (last == 'b' && B > 0) {
//                        result.append('b');
//                        solutionOne(A, --B, C, result);
//                    }
//                    if (last == 'c' && C > 0) {
//                        result.append('c');
//                        solutionOne(A, B, --C, result);
//                    }
//                }
//            }
//        }
//    }


}


