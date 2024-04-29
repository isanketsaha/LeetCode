package StudyPlan.Graph;


import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 */
public class MaxAreaOfIsland {

    int maxArea = 0;
    int[][] grid;

    public static void main(String[] args) {
        int i = new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        });
        System.out.print(i);
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    int area = bfs(row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int rows, int cols) {
        Queue<String> lookup = new LinkedList<>();
        lookup.offer(rows + "-" + cols);
        int area = 0;
        while (!lookup.isEmpty()) {
            String poll = lookup.poll();
            String[] rowsCols = poll.split("-");
            int row = Integer.parseInt(rowsCols[0]);
            int col = Integer.parseInt(rowsCols[1]);
            grid[row][col] = -1;
            if (row < grid.length - 1 && grid[row + 1][col] == 1) {
                lookup.offer((row + 1) + "-" + col);
                grid[row + 1][col] = -1;
            }
            if (row > 0 && grid[row - 1][col] == 1) {
                lookup.offer((row - 1) + "-" + col);
                grid[row - 1][col] = -1;
            }
            if (col < grid[row].length - 1 && grid[row][col + 1] == 1) {
                lookup.offer(row + "-" + (col + 1));
                grid[row][col + 1] = -1;
            }
            if (col > 0 && grid[row][col - 1] == 1) {
                lookup.offer(row + "-" + (col - 1));
                grid[row][col - 1] = -1;
            }
            area++;
        }
        return area;
    }
}
