package prob250.count.univalue.subtrees;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {

    private int res;

    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    // returns true if it is a uni-value tree, false otherwise
    private boolean helper(TreeNode root){
        if(root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if(left && right){

            if(root.left != null && root.val != root.left.val)
                return false;

            if(root.right != null && root.val != root.right.val)
                return false;

            res ++;
            return true;
        }
        return false;
    }
}
