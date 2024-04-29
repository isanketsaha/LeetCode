package StudyPlan.Tree;


/**
 * You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
 * <p>
 * Create a root node whose value is the maximum value in nums.
 * Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 * Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 * Return the maximum binary tree built from nums.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [3,2,1,6,0,5]
 * Output: [6,3,5,null,2,0,null,null,1]
 * Explanation: The recursive calls are as follow:
 * - The largest value in [3,2,1,6,0,5] is 6. Left prefix is [3,2,1] and right suffix is [0,5].
 * - The largest value in [3,2,1] is 3. Left prefix is [] and right suffix is [2,1].
 * - Empty array, so no child.
 * - The largest value in [2,1] is 2. Left prefix is [] and right suffix is [1].
 * - Empty array, so no child.
 * - Only one element, so child is a node with value 1.
 * - The largest value in [0,5] is 5. Left prefix is [0] and right suffix is [].
 * - Only one element, so child is a node with value 0.
 * - Empty array, so no child.
 */
public class MaxTree {


    public static void main(String[] args) {
        TreeNode treeNode = new MaxTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.print(treeNode);
    }

    int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return constructMaximumBinaryTree(0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int start, int end) {

        if (start <= end) {
            int[] ints = subArray(start, end);
            TreeNode root = new TreeNode(nums[ints[1]]);
            root.left = constructMaximumBinaryTree(start, ints[1] - 1);
            root.right = constructMaximumBinaryTree(ints[1] + 1, end);
            return root;
        }
            return null;
    }

    int[] subArray(int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return new int[]{start, index, end};
    }

}
