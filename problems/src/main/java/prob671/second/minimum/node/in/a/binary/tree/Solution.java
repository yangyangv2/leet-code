package prob671.second.minimum.node.in.a.binary.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {
    public int findSecondMinimumValue(TreeNode root) {

        if(root == null) return -1;

        int left = -1;
        if(root.left != null){
            if(root.left.val == root.val){
                left = findSecondMinimumValue(root.left);
            } else {
                left = root.left.val;
            }
        }
        int right = -1;
        if(root.right != null){
            if(root.right.val == root.val){
                right = findSecondMinimumValue(root.right);
            } else {
                right = root.right.val;
            }
        }

        if(left == -1 && right == -1)
            return -1;

        if(left == -1) return right;
        if(right == -1) return left;
        return Math.min(left, right);
    }
}