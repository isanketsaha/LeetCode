package StudyPlan.Array;

public class SearchInMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        SearchInMatrix inMatrix = new SearchInMatrix();
        boolean b = inMatrix.searchMatrix(matrix, 60);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int yDown = matrix.length - 1, xEnd = matrix[0].length - 1;
        int yStart = 0, xStart = 0;

        while (yStart <= yDown) {

            int mid = yStart + yDown % 2;

            if (target >= matrix[mid][xStart] && target <= matrix[mid][xEnd]) {
                while (xStart <= xEnd) {
                    int xMid = xStart + xEnd % 2;
                    if (target == matrix[mid][xMid]) {
                        return true;
                    } else if (target < matrix[mid][xMid]) {
                        xEnd = xMid - 1;
                    } else {
                        xStart = xMid + 1;
                    }
                }
            } else if (target < matrix[mid][xStart]) {
                yDown = mid - 1;
            } else {
                yStart = mid + 1;
            }
        }
        return false;
    }


}
