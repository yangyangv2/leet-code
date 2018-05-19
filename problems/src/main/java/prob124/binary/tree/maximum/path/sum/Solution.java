package prob124.binary.tree.maximum.path.sum;

import utils.tree.TreeNode;

/**
 *  Created by yanya04 on 5/19/2018.
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;

        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);

        int sum = root.val;
        sum += Math.max(0, maxSum(root.left));
        sum += Math.max(0, maxSum(root.right));
        // through root,    not through root
        return Math.max(sum, Math.max(left, right));
    }

    private int maxSum(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;

        int sum = root.val;
        sum += Math.max(0, Math.max(maxSum(root.left), maxSum(root.right)));
        return sum;

    }
}