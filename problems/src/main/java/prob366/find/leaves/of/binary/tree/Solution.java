package prob366.find.leaves.of.binary.tree;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);

        return res;
    }

    // height is the number of edges from a node to
    private int height(TreeNode root, List<List<Integer>> res){

        if(root == null) return -1;

        int height = 1 + Math.max(height(root.left, res), height(root.right, res));

        if(height >= res.size()) res.add(new ArrayList<Integer>());

        res.get(height).add(root.val);

        root.left = null;
        root.right = null;
        return height;
    }
}
