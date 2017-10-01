package prob101.symmetric.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 9/30/2017.
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        if(root == null) return true;

        return dfs(root.left, root.right);

    }


    public boolean dfs(TreeNode left, TreeNode right){

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        if(left.val != right.val) return false;

        return dfs(left.left, right.right) && dfs(left.right, right.left);

    }

}
