package StudyPlan.Tree;

public class GoodNodes {

    public int goodNodes(TreeNode root) {
       return goodNodes(root, null);
    }

    public int goodNodes(TreeNode root, TreeNode prev) {
        if (root != null) {
            int sum = 0;
            if (prev == null || root.val >= prev.val) {
                sum += 1 + goodNodes(root.left, root) + goodNodes(root.left, root);
                return sum;
            }
        }
        return 0;
    }
}
