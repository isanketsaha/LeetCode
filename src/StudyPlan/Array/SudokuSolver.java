package StudyPlan.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    Set<String> lookup = new HashSet<>();
    char[][] board;


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new SudokuSolver().solveSudoku(board);
        System.out.print(Arrays.toString(board));

    }

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int n = Character.getNumericValue(board[i][j]);
                if (n != '.') {
                    lookup.add(n + " is in row " + i);
                    lookup.add(n + " is in col " + j);
                    lookup.add(n + " is in sq " + i / 3 + "-" + j / 3);
                }
            }
        }
        assignSudoku();
    }

    public void assignSudoku() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k < 10; k++) {
                        if (!lookup.contains(k + " is in row " + i) && !lookup.contains(k + " is in col " + j)
                                && !lookup.contains(k + " is in sq " + i / 3 + "-" + j / 3)) {
                            System.out.printf("Row = %s , Col =  %s \n", i, j);
                            board[i][j] = (char) (k + '0');
                            lookup.add(k + " is in row " + i);
                            lookup.add(k + " is in col " + j);
                            lookup.add(k + " is in sq " + i / 3 + "-" + j / 3);
                            break;
                        }
                    }
                }
            }
        }
    }
}
