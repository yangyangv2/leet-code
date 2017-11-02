package prob337.house.robber.iii;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return rob(root, map);
    }

    private int rob(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null) return 0;

        Integer result = map.get(root);
        if(result != null) return result;

        int val = 0;
        if(root.left != null) val += rob(root.left.left, map) + rob(root.left.right, map);
        if(root.right != null) val += rob(root.right.left, map) + rob(root.right.right, map);

        result = Math.max(root.val + val, rob(root.left, map) + rob(root.right, map));
        map.put(root, result);
        return result;
    }
}