package prob270.closest.binary.search.tree.value;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 8/19/2017.
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode upper = root, lower = root, cur = root;
        while(cur != null){
            if(target < cur.val){
                upper = cur;
                cur = cur.left;
            } else if(target > cur.val){
                lower = cur;
                cur = cur.right;
            } else {
                // not possible i suppose
                return cur.val;
            }
        }
        int upperVal = upper.val, lowerVal = lower.val;
        return Math.abs(upperVal - target) < Math.abs(lowerVal - target) ? upperVal : lowerVal;

    }
}