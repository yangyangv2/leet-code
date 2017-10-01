package prob110.balanced.binary.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 10/1/2017.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {

        int height = treeHeight(root);

        return height >= 0;
    }


    private int treeHeight(TreeNode root){

        if(root == null) return 0;

        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        if(leftHeight < 0 || rightHeight < 0) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;

    }

}
