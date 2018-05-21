package prob549.binary.tree.longest.consecutive.sequence.ii;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/10/2018.
 * Modified by yanya04 on 5/21/2018.
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        int[] res = postorder(root);
        return res[2];
    }

    private int[] postorder(TreeNode root){

        if(root == null)
            return new int[]{0, 0, 0};

        int inc = 1, dec = 1, max = 0;

        int[] res = null;

        if(root.left != null){
            res = postorder(root.left);
            if(root.val + 1 == root.left.val){
                inc += res[0];
            }
            if(root.val - 1 == root.left.val){
                dec += res[1];
            }
            max = Math.max(max, res[2]);
        }

        if(root.right != null){

            res = postorder(root.right);
            if(root.val + 1 == root.right.val){
                inc = Math.max(inc, res[0] + 1);
            }

            if(root.val - 1 == root.right.val){
                dec = Math.max(dec, res[1] + 1);
            }
            max = Math.max(max,res[2]);

        }
        max = Math.max(max, inc + dec -1);
        return new int[]{inc, dec, max};
    }

}
