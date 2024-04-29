package StudyPlan.SlidingWindow;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
 * Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
 * Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 *
 *
 * Example 1:
 *
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 */
public class Fruits {

    public static void main(String[] args) {
        System.out.print(new Fruits().totalFruit(new int[]{0,1,2,2}));
    }
    public int totalFruit(int[] fruits) {
        int maxWindow = 0;
        int preElement = -1;
        int j ;
        for(int i = 0; i < fruits.length; i++){
            for( j = i + 1 ; j <  fruits.length; j++){
                if(fruits[j] != fruits[j-1]){
                    if(preElement == -1){
                        preElement = fruits[i];
                    } else if(fruits[j] != preElement){
                        preElement = -1;
                        maxWindow = Math.max(maxWindow, j-i);
                        break;
                    }

                }

            }
            maxWindow = Math.max(maxWindow, j-i);
        }
        return maxWindow;
    }
}
