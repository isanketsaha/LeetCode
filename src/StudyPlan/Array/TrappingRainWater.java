package StudyPlan.Array;

public class TrappingRainWater {


    public static void main(String[] args) {
        int trap = new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    public int trap(int[] height) {
        int vol = 0;
        for (int i = 0; i < height.length-1; i++) {
            if(height[i] > height[i+1]){
                int end = i+1;
                while(height.length > end && height[i] > height[end]){
                    vol += (Math.abs(height[i] - height[end])) ;
                    end++;
                }
                if(height.length > end  && height[i] < height[end]){
                    i = end-1;
                }
            }
        }
        return vol;
    }
}
