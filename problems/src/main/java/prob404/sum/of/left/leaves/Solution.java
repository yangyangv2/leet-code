package prob404.sum.of.left.leaves;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {

    // 1. root is not counted as left leave

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }


    private int helper(TreeNode root, boolean isLeft){
        if(root == null)
            return 0;

        if(isLeft && root.left == null && root.right == null)
            return root.val;

        int left = helper(root.left, true);
        int right = helper(root.right, false);

        return left + right;
    }

}