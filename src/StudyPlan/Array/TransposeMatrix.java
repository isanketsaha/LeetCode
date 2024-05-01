package StudyPlan.Array;

import java.util.stream.IntStream;

/**
 * Given a 2D integer array matrix, return the transpose of matrix.
 * <p>
 * The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        IntStream.range(0, matrix.length)
                .forEach(i -> IntStream.range(0, matrix[i].length)
                        .forEach(j -> result[j][i] = matrix[i][j]));
        return result;
    }
}
