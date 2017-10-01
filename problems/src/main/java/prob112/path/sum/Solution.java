package prob112.path.sum;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 10/1/2017.
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null) return false;

        if(root.left == null && root.right == null && sum == root.val) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum -root.val);

    }
}
