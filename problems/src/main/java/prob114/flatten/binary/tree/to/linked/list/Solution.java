package prob114.flatten.binary.tree.to.linked.list;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 10/8/2017.
 */
public class Solution
{
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

}
