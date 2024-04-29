package StudyPlan.TwoPointers;

public class WinnerPredict {

    public static void main(String[] args) {
        boolean b = new WinnerPredict().predictTheWinner(new int[]{1,5,233,7});
        System.out.print(b);
    }
    public boolean predictTheWinner(int[] nums) {
        int resultA = 0;
        int resultB = 0;
        int leftP = 0;
        int rightP = nums.length -1;
        int count =0;
        while(leftP <= rightP){
            int choice = 0;
            if(nums[leftP] < nums[rightP]){
                choice = nums[rightP];
                --rightP;
            } else {
                choice = nums[rightP];
                ++leftP;
            }
            if(count % 2 == 0){
                resultA += choice;
            } else{
                resultB += choice;
            }
            ++count;
        }

        return resultA > resultB;
    }
}
