package prob236.lowest.common.ancestor.of.a.binary.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/20/2018.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || p == root || q == root) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;

        if(right == null) return left;

        return root;
    }
}
