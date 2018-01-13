package prob298.binary.tree.longest.consecutive.sequence;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/10/2018.
 */
public class Solution {
    /*
        pre-order:

    */

    private int max = 0;

    public int longestConsecutive(TreeNode root) {

        if(root == null)
            return max;

        preorder(root, 1);

        return max;
    }


    private void preorder(TreeNode node, int target){

        max = Math.max(target, max);

        if(node.left != null){
            if(node.val + 1 == node.left.val){
                preorder(node.left, target + 1);
            } else {
                preorder(node.left, 1);
            }
        }

        if(node.right != null){
            if(node.val + 1 == node.right.val){
                preorder(node.right, target + 1);
            } else{
                preorder(node.right, 1);
            }
        }
    }
}