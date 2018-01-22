package prob285.inorder.successor.in.bst;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {

/*

        3
       / \
      1   6
     /\   /\
    0  2 4  5
*/


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //return recursive(root, p);
        return iterative(root, p);
    }

    private TreeNode iterative(TreeNode root, TreeNode p){

        TreeNode res = null;

        while(root != null){
            if(p.val >= root.val){
                root = root.right;
            } else {
                // p.val < cur.val
                res = root;
                root = root.left;
            }
        }
        return res;
    }


    private TreeNode recursive(TreeNode root, TreeNode p){
        if(root == null) return null;

        if(p.val >= root.val){
            return recursive(root.right, p);
        } else {
            TreeNode node = recursive(root.left, p);
            if(node != null){
                return node;
            } else {
                return root;
            }
        }

    }
}
