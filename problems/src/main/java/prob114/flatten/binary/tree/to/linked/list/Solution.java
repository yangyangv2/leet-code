package prob114.flatten.binary.tree.to.linked.list;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 10/8/2017.
 * Modified by yanya04 on 5/19/2018.
 */
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);

        root.right = left;

        TreeNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        cur.right = right;
    }
}