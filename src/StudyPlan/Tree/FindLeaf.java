package StudyPlan.Tree;

import java.util.Arrays;

public class FindLeaf {

    String first = "";
    String second = "";
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        findNode(root1, root2);
        return first == second;
    }

    public void findNode(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null)
            return;
        if(root1.left == null && root1.right == null){
            first = first + root1.val + "#";

        }
        if(root2.left == null && root2.right == null){
            second = second + root2.val + "#";

        }

        leafSimilar(root1.left, root2.left) ;
        leafSimilar(root1.right, root2.right);
    }

    public static void main(String[] args) {
//        TreeNode first = new TreeNode(1);
//        first.left = new TreeNode(2);
//        first.right = new TreeNode(3);
//
//
//        TreeNode second = new TreeNode(1);
//        second.left = new TreeNode(3);
//        second.right = new TreeNode(2);
//
//        boolean b = new FindLeaf().leafSimilar(first, second);
//        System.out.println(first);
//        System.out.println(second);

        new FindLeaf().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

    public int removeDuplicates(int[] nums) {
        String[] expectedNums = new String[nums.length];
        Arrays.fill(expectedNums, "_");
        int count = 1;
        expectedNums[0] = String.valueOf(nums[0]);
        for(int i =1;i< nums.length; i++){
            if(nums[i] != Integer.valueOf(expectedNums[count-1])){
                expectedNums[count] = String.valueOf(nums[i]);
                count++;
            }
        }
        System.out.println(Arrays.toString(expectedNums));
        return count+1;
    }
}
