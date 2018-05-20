package prob543.diameter.of.binary.tree;

import utils.tree.TreeNode;

/**
 *  Created by yanya04 on 5/19/2018.
 */
public class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        int res = dfs(root);

        return res == 0 ? res: res - 1;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            return 1;

        int left = dfs(root.left);
        int right = dfs(root.right);

        return Math.max(Math.max(left, right), 1 +
                longestThroughRoot(root.left) +
                longestThroughRoot(root.right));
    }

    private int longestThroughRoot(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null)
            return 1;

        return 1 + Math.max(longestThroughRoot(node.left),
                longestThroughRoot(node.right));

    }
}