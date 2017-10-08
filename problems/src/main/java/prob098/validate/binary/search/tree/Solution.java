package prob098.validate.binary.search.tree;

import utils.tree.TreeNode;

import java.util.Stack;

/**
 * Created by yanya04 on 10/1/2017.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {

        // iterative inorder-traverse
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
