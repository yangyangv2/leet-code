package prob776.split.bst;

import utils.tree.TreeNode;

public class Solution {
    public TreeNode[] splitBST(TreeNode root, int V) {

        TreeNode small = null, large = null;
        TreeNode[] trees = null;
        if(root == null){

        } else if(V == root.val){
            small = root;
            large = root.right;
            root.right = null;
        } else if(V < root.val){
            trees = splitBST(root.left, V);
            small = trees[0];
            large = root;
            // get the large sub tree and attach to the left child
            root.left = trees[1];
        } else {
            // in this context, we're looking for splited tree on the right sub tree
            trees = splitBST(root.right, V);
            small = root;
            large = trees[1];
            // get the small sub tree and attach to the right child
            root.right = trees[0];
        }

        return new TreeNode[]{small, large};

    }
}