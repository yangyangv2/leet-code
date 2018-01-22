package prob687.longest.univalue.path;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/22/2018.
 */
public class Solution {

    /*
                  1
                 / \
                4   5
               / \   \
              4   4   5
    */
    int max;
    public int longestUnivaluePath(TreeNode root) {

        max = 0;
        helper(root);
        return max;
    }


    private int helper(TreeNode root){

        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        if(root.left != null && root.val == root.left.val) left ++;
        else left = 0;

        if(root.right != null && root.val == root.right.val) right ++;
        else right = 0;

        max = Math.max(right + left, max);
        return Math.max(right, left);
    }

}
