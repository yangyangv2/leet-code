package prob156.binary.tree.upside.down;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/14/2018.
 */
public class Solution {
    /*
            1
           / \
          2   3
         / \
        4   5

       4
      / \
     5   2
        / \
       3   1

            1
          R/
          2-L-3
        R/
       (4)-L-5
    */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null)
            return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.right = root;         // ---> root
        root.left.left = root.right;     //
        root.left = null;
        root.right = null;
        return newRoot;
    }
}