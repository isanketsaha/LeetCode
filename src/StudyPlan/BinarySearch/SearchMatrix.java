package StudyPlan.BinarySearch;

import java.util.Arrays;

public class SearchMatrix {

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] al = {{1},{2}};
        searchMatrix.searchMatrix(al, 1);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length ; i++){
            if(matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target){
                return searchMatrix(matrix[i], target, 0 , matrix[0].length);
            }
        }
        return false;
    }

    public boolean searchMatrix(int[] matrix, int target, int start, int end) {
        System.out.println(Arrays.toString(matrix));
        if(start <= end){
            int mid = (start + end) / 2;
            System.out.print("Mid = "+mid);
            if(matrix[mid] == target){
                return true;
            }
            if(matrix[mid] < target){
                return searchMatrix(matrix, target,  mid+1 , end);
            }
            else{
                return searchMatrix(matrix, target,  start, mid-1);
            }
        }
        else{
            return false;
        }
    }
}
