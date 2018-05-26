package prob776.split.bst;

import utils.tree.TreeNode;

/**
 *  Modified by yanya04 5/13/2018.
 *  Modified by yanya04 5/25/2018.
 */
public class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(root == null) return new TreeNode[]{null, null};

        TreeNode left = null, right = null;
        TreeNode[] nodes = null;

        if(root.val == V){
            left = root;
            right = root.right;
            root.right = null;
        }
        else if(V < root.val){
            right = root;
            nodes = splitBST(root.left, V);
            root.left = nodes[1];
            left = nodes[0];
        } else {
            left = root;
            nodes = splitBST(root.right, V);
            root.right = nodes[0];
            right = nodes[1];
        }

        return new TreeNode[]{left, right};
    }
}