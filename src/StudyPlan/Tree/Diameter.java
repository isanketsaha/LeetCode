package StudyPlan.Tree;

public class Diameter {

    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, null, new TreeNode(2));
       Diameter d = new Diameter();
        int i = d.diameterOfBinaryTree(node);
        System.out.print(i);
    }


    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfTree(root);
        return max;
    }

    public int diameterOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = diameterOfTree(root.left);
            int right = diameterOfTree(root.right);
            max = Math.max(max, left + right);
            return Math.max(left, right) + 1;
        }
    }
}
