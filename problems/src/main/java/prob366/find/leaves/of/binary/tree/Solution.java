package prob366.find.leaves.of.binary.tree;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  Modified by yanya04 5/14/2018.
 */
public class Solution {
    /*
              1
             / \
            2   3
           / \
          4   5

    */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        remove(root, res);
        return res;
    }

    private int remove(TreeNode node, List<List<Integer>> res){

        if(node == null) return 0;

        int depth = Math.max(remove(node.left, res), remove(node.right, res));

        if(depth == res.size()){
            res.add(new ArrayList<>());
        }

        res.get(depth).add(node.val);

        return depth + 1;

    }
}
