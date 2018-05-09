package prob337.house.robber.iii;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Modified by yanya04 on 5/7/2018.
 */
public class Solution {
    /*
        1. rob
        2. not rob
    */

    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if(root == null) return 0;

        if(map.containsKey(root)) return map.get(root);

        int value =  Math.max(root.val + notrob(root.left) + notrob(root.right),
                rob(root.left) + rob(root.right));

        map.put(root, value);

        return value;
    }

    private int notrob(TreeNode root){

        if(root == null) return 0;

        return rob(root.left) + rob(root.right);
    }

}