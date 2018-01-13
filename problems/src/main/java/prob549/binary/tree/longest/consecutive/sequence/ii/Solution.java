package prob549.binary.tree.longest.consecutive.sequence.ii;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/10/2018.
 */
public class Solution {

    /*
        divide-and-conquer
        post-order traverse (LRT)
    */
    private int max = 0;

    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;

        postorder(root);

        return max;
    }


    private int[] postorder(TreeNode node){

        int inc = 1, dec = 1;

        if(node.left != null){
            int[] res = postorder(node.left);
            if(node.val + 1 == node.left.val){
                inc += res[0];
            } else if(node.val -1 == node.left.val){
                dec += res[1];
            }
        }

        if(node.right != null){
            int[] res = postorder(node.right);
            if(node.val + 1 == node.right.val){
                inc = Math.max(inc, res[0] + 1);
            } else if(node.val - 1 == node.right.val){
                dec = Math.max(dec, res[1] + 1);
            }
        }

        max = Math.max(max, inc + dec -1);
        return new int[]{inc, dec};
    }


}
