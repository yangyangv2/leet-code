package prob776.split.bst;

import utils.tree.TreeNode;

/**
 *  Modified by yanya04 5/13/2018.
 */
public class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {

        TreeNode left = null, right = null;
        TreeNode[] temp = null;

        if(root == null){
            // do nothing;
        } else if (root.val == V){
            left = root;
            right = root.right;
            root.right = null;
        } else if(root.val < V){
            left = root;
            temp = splitBST(root.right, V);
            root.right = temp[0];
            right = temp[1];
        } else {
            right = root;
            temp = splitBST(root.left, V);
            root.left = temp[1];
            left = temp[0];
        }

        return new TreeNode[]{left, right};
    }
}