package StudyPlan.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {


    public static void main(String[] args) {
        int i = new RottingOranges().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
        System.out.print(i);
    }

    public int orangesRotting(int[][] grid) {
        Queue<String> lookup = new LinkedList<>();
        int[][] seqs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    lookup.add(i + "-" + j);
                }
            }
        }
        while (!lookup.isEmpty()) {
            boolean adjRotten = false;
            int size = lookup.size();
            for (int k = 0; k < size; k++) {
                String poll = lookup.poll();
                int i = Integer.valueOf(poll.split("-")[0]);
                int j = Integer.valueOf(poll.split("-")[1]);
                for (int[] seq : seqs) {
                    int row = i + seq[0];
                    int col = j + seq[1];
                    if (row >= 0 && col >= 0
                            && row < grid.length
                            && col < grid[row].length
                            && grid[row][col] == 1) {
                        lookup.add(row + "-" + col);
                        grid[row][col] = 2;
                        adjRotten = true;
                    }
                }
            }
            if (adjRotten) {
                count++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
