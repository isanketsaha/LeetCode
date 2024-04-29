package StudyPlan.Tree;

import java.util.ArrayList;
import java.util.List;

public class LCA {
    TreeNode p;
    TreeNode q;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        p = p;
        q = q;
        ArrayList<TreeNode> left = new ArrayList<>();
        ArrayList<TreeNode> right = new ArrayList<>();
        lowestCommonAncestor(root.left, p, left);
        lowestCommonAncestor(root.right, p, right);
        System.out.print(left.size());
        System.out.print(right.size());
        return null;
    }

    public boolean lowestCommonAncestor(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root != null) {
            if (root == p) {
                list.add(root);
                return true;
            }
            if (lowestCommonAncestor(root.right, p, list)) {
                list.add(root.right);
                return true;
            }
            if (lowestCommonAncestor(root.left, p, list)) {
                list.add(root.left);
                return true;
            }
        }
        return false;

    }
}
