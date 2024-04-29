package StudyPlan.Tree;

public class SortedArrayToBST {

    int[] nums;
    TreeNode root;

    public static void main(String[] args) {
        TreeNode treeNode = new SortedArrayToBST().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.print(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return sortedArrayToBST(0, nums.length - 1);

    }

    public TreeNode sortedArrayToBST(int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
//            if (end % 2 != 0) {
//                mid += 1;
//            }
            return new TreeNode(nums[mid], sortedArrayToBST(start, mid - 1), sortedArrayToBST(mid + 1, end));
        }
        return null;
    }
}
