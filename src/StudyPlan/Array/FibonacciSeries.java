package StudyPlan.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibonacciSeries {

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(3);
        al.add(6);
        al.add(2);
        al.add(3);
        al.add(5);
        System.out.print(new FibonacciSeries().numberOfTokens(4, new int[][]{}));
    }

    public int fib(int n) {
        List<Integer> f = new ArrayList<>();
        if (n == 1 || n == 2)
            return n - 1;
        f.add(0);
        f.add(1);
        while (f.size() < n) {
            f.add(f.get(f.size() - 1) + f.get(f.size() - 2));
        }
        return f.get(f.size() - 1) + f.get(f.size() - 2);
    }
    public static int getScoreDifference(List<Integer> numSeq) {
        int teamA = 0, teamB = 0;
        int left = 0, right = numSeq.size() - 1;
        boolean flip = false;
        // Write your code here
        while(left <= right){
            int digit = 0;
            if(!flip) {
                digit = numSeq.get(left++);
            } else {
                digit = numSeq.get(right--);
            }
            if((left + right) % 2 == 0){
                teamB +=digit;

            } else {
                teamA +=digit;
            }

        }
        return teamA - teamB;
    }
    public static int numberOfTokens(int expiryLimit, int[][] commands) {
        Map<Integer, Integer> tokenExpiryTimes = new HashMap<>();
        int activeTokens = 0;

        for (int[] command : commands) {
            int type = command[0];
            int tokenId = command[1];
            int time = command[2];

            if (type == 0) { // Create token command
                tokenExpiryTimes.put(tokenId, time + expiryLimit);
            } else if (type == 1 && tokenExpiryTimes.containsKey(tokenId)
                    && tokenExpiryTimes.get(tokenId) >= time) { // Reset token command
                tokenExpiryTimes.put(tokenId, time + expiryLimit);
            }
        }

        // Calculate the number of active tokens at the end
        int maxTime = commands[commands.length - 1][2];
        for (int expiryTime : tokenExpiryTimes.values()) {
            if (expiryTime > maxTime) {
                activeTokens++;
            }
        }

        return activeTokens;
    }
}
