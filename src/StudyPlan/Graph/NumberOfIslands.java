package StudyPlan.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 */
public class NumberOfIslands {

    Set<String> visited = new HashSet<>();
    char[][] grid;

    public static void main(String[] args) {
        new NumberOfIslands().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'1', '1', '0', '1', '1'}});
    }

    public int numIslands(char[][] grid) {
        int sumOfIsland = 0;
        this.grid = grid;
        for (int rows = 0; rows < grid.length; rows++) {
            for (int cols = 0; cols < grid[0].length; cols++) {
                if (grid[rows][cols] == '1' && visited.add(rows + "-" + cols)) {
                    ++sumOfIsland;
                    bfs(rows, cols);
                }
            }
        }
        return sumOfIsland;

    }

    private void bfs(int rows, int cols) {
        Queue<String> q = new LinkedList<>();
        q.offer(rows + "-" + cols);

        while (!q.isEmpty()) {
            String poll = q.poll();
            String[] split = poll.split("-");
            rows = Integer.valueOf(split[0]);
            cols = Integer.valueOf(split[1]);
            if (rows + 1 < grid.length && grid[rows + 1][cols] == '1' && visited.add(rows + 1 + "-" + cols)) {
                q.offer(rows + 1 + "-" + cols);
            }
            if (rows - 1 > 0 && grid[rows - 1][cols] == '1' && visited.add(rows - 1 + "-" + cols)) {
                q.offer(rows - 1 + "-" + cols);
            }
            if (cols + 1 < grid[0].length && grid[rows][cols + 1] == '1' && visited.add(rows + "-" + (cols + 1))) {
                q.offer(rows  + "-" + (cols+1));
            }
            if (cols - 1 > 0 && grid[rows][cols - 1] == '1' && visited.add(rows + "-" + (cols - 1))) {
                q.offer(rows  + "-" + (cols - 1));
            }
        }
    }

}
