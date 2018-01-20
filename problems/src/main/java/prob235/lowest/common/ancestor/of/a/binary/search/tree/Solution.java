package prob235.lowest.common.ancestor.of.a.binary.search.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/19/2018.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // < > or ==
            return root;
        }

    }


}
