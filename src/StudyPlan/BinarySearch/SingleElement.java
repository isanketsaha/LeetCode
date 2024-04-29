package StudyPlan.BinarySearch;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 *
 * Your solution must run in O(log n) time and O(1) space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 */
public class SingleElement {

    public static void main(String[] args) {
        System.out.print(new SingleElement().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
    public int singleNonDuplicate(int[] nums) {
        return singleNonDuplicate(nums, 0 , nums.length -1) ;
    }

    public int singleNonDuplicate(int[] nums, int startIndex, int endIndex) {
        if(startIndex <= endIndex){
            int midIndex = (startIndex + endIndex)/2;
            if((midIndex < nums.length - 1 && nums[midIndex] == nums[midIndex+1]) ) {
                if((startIndex + midIndex + 1) % 2 != 0){
                    return singleNonDuplicate(nums, midIndex + 2 , endIndex) ;
                }else{
                    return singleNonDuplicate(nums,startIndex , midIndex - 1) ;
                }

            } else if (midIndex > 0 && nums[midIndex] == nums[midIndex - 1 ]){
                if((startIndex + midIndex - 1) % 2 != 0){
                    return  singleNonDuplicate(nums, startIndex , midIndex - 2) ;
                }
                else{
                    return  singleNonDuplicate(nums, midIndex + 1 ,  endIndex) ;
                }
            }
            else{
                return nums[midIndex];
            }
        }
        return -1;
    }
}
