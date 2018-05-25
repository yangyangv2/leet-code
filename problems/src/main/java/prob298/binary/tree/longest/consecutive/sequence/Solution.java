package prob298.binary.tree.longest.consecutive.sequence;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/10/2018.
 * Modified by yanya04 on 5/19/2018.
 * Modified by yanya04 on 5/24/2018.
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;

        return dfs(root, 1, null);
    }

    private int dfs(TreeNode node, int count, TreeNode parent){

        if(node == null) return count;

        count = (parent == null || parent.val + 1 != node.val) ? 1: count + 1;

        int left = dfs(node.left, count, node);
        int right = dfs(node.right, count, node);

        return Math.max(Math.max(left, right), count);

    }
}