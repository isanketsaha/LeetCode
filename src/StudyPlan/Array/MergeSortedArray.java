package StudyPlan.Array;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        MergeSortedArray sortedArray = new MergeSortedArray();
        int[] firstArray = {1, 2, 3, 0, 0, 0};
        int[] secondArray = {2, 5, 6};

        sortedArray.merge(firstArray, 3, secondArray, 3);
        System.out.println(Arrays.toString(firstArray));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1,j = n - 1,k = m + n - 1;
        while (j >= 0)
            nums1[k--] = i >= 0 && nums1[i] > nums2[j]? nums1[i--]: nums2[j--];

    }
}
