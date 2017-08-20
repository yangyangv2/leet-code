package prob230.kth.smallest.element.in.a.bst;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 8/18/2017.
 */
public class Solution {
    private int n = 1;

    public int kthSmallest(TreeNode root, int k) {
/*
    use inorder-traverse to find kth smallest
*/
        if(root == null){
            return -1;
        }

        int left = kthSmallest(root.left, k);

        if(left != -1) return left;

        if(k == n){
            return root.val;
        }
        n ++;

        return kthSmallest(root.right, k);
    }
}
