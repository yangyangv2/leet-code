package prob110.balanced.binary.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 10/1/2017.
 * Modified by yanya04 on 6/10/2018.
 */
public class Solution {

    private int height(TreeNode node){

        if(node == null)
            return 0;

        int left = height(node.left);
        if(left == -1) return -1;

        int right = height(node.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);

    }

    public boolean isBalanced(TreeNode root) {

        if(height(root) == -1)
            return false;
        return true;

    }
}