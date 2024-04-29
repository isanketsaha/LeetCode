package StudyPlan.BinarySearch;

public class PeakElement {

    public static void main(String[] args) {
        System.out.print(new PeakElement().findPeakElement(new int[]{1,2}));
    }
    public int findPeakElement(int[] nums) {
        return  findPeakElement(nums, 0 , nums.length -1);
    }

    public int findPeakElement(int[] nums, int start, int end) {
        int mid = (start + end) /2;
        if(start <= end){
            if((mid <= 1 || nums[mid] > nums[mid - 1])
                    && (mid+1 >= nums.length || nums[mid] > nums[mid + 1])){
                return mid;
            } else if(mid <= 1 || nums[mid] < nums[mid - 1]){
                return findPeakElement(nums, start , mid - 1);
            } else{
                return findPeakElement(nums, mid + 1, end);
            }
        }
        return mid;
    }
}
