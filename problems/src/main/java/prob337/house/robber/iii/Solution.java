package prob337.house.robber.iii;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Modified by yanya04 on 5/7/2018.
 * Modified by yanya04 on 5/24/2018.
 */
public class Solution {

    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {

        if(root == null)
            return 0;

        if(map.containsKey(root)){
            return map.get(root);
        }

        int res = Math.max(root.val + norob(root.left) +
                norob(root.right), norob(root));
        map.put(root, res);

        return res;
    }

    private int norob(TreeNode root){
        if(root == null)
            return 0;
        return rob(root.left) + rob(root.right);
    }

}