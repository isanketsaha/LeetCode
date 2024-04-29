package StudyPlan.SlidingWindow;

public class MinOperationToZero {

    public static void main(String[] args) {
       System.out.print(new MinOperationToZero().minOperations(new int[]{3,2,20,1,1,3}, 10));
    }
    public int minOperations(int[] nums, int x) {
        return minOperations(nums, x  , 0 , 0 , nums.length - 1);
    }
    public int minOperations(int[] nums, int x, int result, int fromLeft , int fromRight) {
        if(fromLeft < fromRight) {
            if(x <= 0){
                return x == 0 ? result : -1;
            }
            else if(nums[fromLeft] < nums[fromRight]){
                return  minOperations(nums, x - nums[fromRight] , ++result, fromLeft , --fromRight);
            }
            else{
                return minOperations(nums, x - nums[fromLeft] , ++result, ++fromLeft , fromRight);
            }
        }
        return -1;
    }
}
