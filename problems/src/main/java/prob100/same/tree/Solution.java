package prob100.same.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 9/30/2017.
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
