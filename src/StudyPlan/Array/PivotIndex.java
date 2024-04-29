package StudyPlan.Array;

public class PivotIndex {

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        int i = pivotIndex.pivotIndex(new int[]{1, 2, 3});
        System.out.print(i);
    }

    public int pivotIndex(int[] nums) {

        int index = 0, startIndex = 0, leftSum = 0, rightSum = 0;
        int endIndex = nums.length - 1;
        while ((startIndex < index || endIndex > index) && index >= 0 && index < nums.length ) {
            if (startIndex < index) {
                leftSum += nums[startIndex++];

            } else if (startIndex == index && index > 0) {
                rightSum -= nums[startIndex--];
            }
            if (endIndex > index) {
                rightSum += nums[endIndex--];
            } else if (endIndex <= index && index < nums.length) {
                rightSum -= nums[++endIndex];
            }
            if (leftSum == rightSum) {
                return index;
            } else if (leftSum != rightSum && leftSum + 1 >= index || endIndex - 1 <= index) {
                index++;
            }
        }

        return -1;
    }

}
