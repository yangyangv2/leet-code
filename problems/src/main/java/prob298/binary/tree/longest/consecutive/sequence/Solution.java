package prob298.binary.tree.longest.consecutive.sequence;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/10/2018.
 * Modified by yanya04 on 5/19/2018.
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;

        return Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
    }

    private int dfs(TreeNode root, int count, int val){
        if(root == null)
            return count;

        count = (root.val - val == 1) ? count + 1:1;

        int left = dfs(root.left, count, root.val);
        int right = dfs(root.right, count, root.val);

        return Math.max(Math.max(left, right), count);
    }
}