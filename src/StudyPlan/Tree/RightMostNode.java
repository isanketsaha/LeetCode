package StudyPlan.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree,
 * imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * Input: root = [1,null,3]
 * Output: [1,3]
 */
public class RightMostNode {
    List<List<Integer>> tmp = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        bfs(root, 1);
        for (List<Integer> t : tmp) {
            result.get(t.size() - 1);
        }
        return result;
    }

    public void bfs(TreeNode root, int level) {
        if (root != null) {
            if (tmp.size() < level) {
                tmp.add(new ArrayList<>());
            }
            tmp.get(level)
                    .add(root.val);
            bfs(root.left, level + 1);
            bfs(root.right, level + 1);
        }

    }
}
