package StudyPlan.Array;


import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix.
 * Two robots are playing a game on this matrix.
 * <p>
 * Both robots initially start at (0, 0) and want to reach (1, n-1). Each robot may only move to the right ((r, c) to (r, c + 1))
 * or down ((r, c) to (r + 1, c)).
 * <p>
 * At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path.
 * For all cells (r, c) traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from (0, 0) to (1, n-1),
 * collecting the points on its path. Note that their paths may intersect with one another.
 * <p>
 * The first robot wants to minimize the number of points collected by the second robot. In contrast, the second robot wants to maximize
 * the number of points it collects. If both robots play optimally, return the number of points collected by the second robot.
 */
public class GridGame {

    int[][] moves = new int[][]{{1, 0}, {0, 1}};

    public static void main(String[] args) {
        long l = new GridGame().gridGame(new int[][]{{2, 5, 4}, {1, 5, 1}});
        System.out.println(l);
    }

    public long gridGame(int[][] grid) {
        String sIndex = "0#0";
        long l = gridGame(grid, sIndex);
        System.out.println(l);
        long l1 = gridGame(grid, sIndex);
        System.out.println(l1);
        return 0;
    }

    public long gridGame(int[][] grid, String index) {
        String[] poll = index.split("#");
        int row = Integer.valueOf(poll[0]);
        int col = Integer.valueOf(poll[1]);
        if (row == -1 && col == -1) {
            return 0;
        }
        int maxR = -1, maxC = -1, sum = 0, max = grid[row][col];
        grid[row][col] = 0;
        for (int[] move : moves) {
            int r = move[0];
            int c = move[1];
            if (r + row < grid.length && c + col < grid[0].length && grid[r + row][c + col] > sum) {
                sum = grid[r + row][c + col];
                maxR = r + row;
                maxC = c + col;
            }
        }
        long l = gridGame(grid, maxR + "#" + maxC);
        return l + max;
    }
}
