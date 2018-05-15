package prob270.closest.binary.search.tree.value;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 8/19/2017.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode cur = root, upper = root, lower = root;
        while(cur != null){
            if(cur.val < target){
                lower = cur;
                cur = cur.right;
            } else if(cur.val > target){
                upper = cur;
                cur = cur.left;
            } else {
                return cur.val;
            }
        }
        return (Math.abs(target - lower.val) < Math.abs(upper.val - target))? lower.val : upper.val;
    }
}