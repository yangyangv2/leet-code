package prob543.diameter.of.binary.tree;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *  Created by yanya04 on 5/19/2018.
 *  Modified by yanya04 on 6/12/2018.
 */
public class Solution {

    /*
        longest path
        through root or not through root
    */
    public int diameterOfBinaryTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();

        int res = dfs(root, map);

        return res > 0 ? res - 1: 0;
    }


    private int dfs(TreeNode root, Map<TreeNode, Integer> map){

        if(root == null) return 0;

        int left = dfs(root.left, map), right =dfs(root.right, map);

        return Math.max( Math.max(left, right), 1 +
                thruRoot(root.left, map) + thruRoot(root.right, map));
    }

    private int thruRoot(TreeNode root, Map<TreeNode, Integer> map){
        if(root == null) return 0;
        Integer len = map.get(root);
        if(len != null) return len;

        len = 1 + Math.max(thruRoot(root.left, map), thruRoot(root.right, map));
        map.put(root, len);
        return len;
    }

}