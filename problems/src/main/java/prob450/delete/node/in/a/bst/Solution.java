package prob450.delete.node.in.a.bst;

import utils.tree.TreeNode;

public class Solution {

    /*
        return root of the sub-tree after deletion
    */
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;

        if(root.val < key){
            root.right = deleteNode(root.right, key);
        } else if(root.val > key){
            root.left = deleteNode(root.left, key);
        } else {
            if(root.right == null) return root.left;
            else{
                root.val = findMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int findMin(TreeNode node){
        TreeNode cur = node, pre = null;
        while(cur != null){
            pre = cur;
            cur = cur.left;
        }
        return pre.val;
    }
}
