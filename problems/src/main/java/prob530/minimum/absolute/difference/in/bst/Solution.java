package prob530.minimum.absolute.difference.in.bst;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 8/10/2017.
 */
public class Solution {
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {

        if(root == null){
            return Integer.MAX_VALUE;
        }

        int min = getMinimumDifference(root.left);

        if(prev != null){
            min = Math.min(root.val - prev.val, min);
        }
        prev = root;

        min = Math.min(getMinimumDifference(root.right), min);

        return min;
    }
}
