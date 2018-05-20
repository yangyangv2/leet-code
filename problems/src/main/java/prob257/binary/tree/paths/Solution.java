package prob257.binary.tree.paths;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  Modified by yanya04 on 5/19/2018.
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        backtrack(res, null, root);
        return res;
    }
    private void backtrack(List<String> res, String parent, TreeNode node){
        if(node == null){
            return;
        }

        parent = parent == null ? String.valueOf(node.val) : parent + "->" + node.val;

        if(node.left == null && node.right == null){
            res.add(parent);
            return;
        }

        backtrack(res, parent, node.left);
        backtrack(res, parent, node.right);
    }

}