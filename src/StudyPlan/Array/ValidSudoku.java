package StudyPlan.Array;

import java.util.*;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        ValidSudoku sudoku = new ValidSudoku();
        boolean validSudoku = sudoku.isValidSudoku(board);
        System.out.println(validSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> row = new HashSet<>();
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                boolean add = row.add(board[i][j] + " index at " + i);
                boolean add1 = row.add(board[i][j] + " index at " + j);
                boolean add2 = row.add(board[i][j] + " sub-index at " + i / 3 + "-" + j / 3);
                if (!add || !add1 || !add2) {
                    return false;
                }
            }
        }

        return true;
    }
}
