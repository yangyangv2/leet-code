package prob337.house.robber.iii;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Modified by yanya04 on 5/7/2018.
 * Modified by yanya04 on 5/24/2018.
 * Modified by yanay04 on 6/1/2018.
 */
public class Solution {
    public int rob(TreeNode root) {
        int[] res = subrob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] subrob(TreeNode root){
        if(root == null) return new int[2];

        int[] left = subrob(root.left);
        int[] right = subrob(root.right);

        int[] res = new int[2];
        //not rob root
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // rob root
        res[1] = root.val + left[0] + right[0];

        return res;
    }

}