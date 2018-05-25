package prob450.delete.node.in.a.bst;

import utils.tree.TreeNode;

/**
 *  Modified by yanya04 on 5/24/2018.
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        } else if(key > root.val){
            root.right = deleteNode(root.right, key);
        } else {
            // delete root
            if(root.right == null){
                return root.left;
            } else {
                root.val = findMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int findMin(TreeNode root){
        int min = 0;
        while(root != null){
            min = root.val;
            root = root.left;
        }
        return min;
    }
}