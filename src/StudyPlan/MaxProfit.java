package StudyPlan;

import java.util.HashSet;
import java.util.Set;

public class MaxProfit {

    public static void main(String[] args) {
        int i = new MaxProfit().maxProfit(new int[]{2, 4, 1});
        System.out.println(i);
    }

    public int maxProfit(int[] price) {
        int profit = 0;
        for(int i = 0 ; i < price.length ; i++ ) {
            for(int j = i+1 ; j< price.length ;j++) {
                if(price[i] < price[j]){
                    if(profit < (price[j] - price[i])){
                        profit = (price[j] - price[i]);
                    }
                }
                else{
                    break;
                }
            }
        }
        return profit;

    }
}
