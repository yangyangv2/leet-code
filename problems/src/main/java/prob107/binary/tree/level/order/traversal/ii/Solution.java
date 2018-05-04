package prob107.binary.tree.level.order.traversal.ii;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * Created by yanya04 on 1/9/2018.
 * Modified by yanya04 on 4/23/2018
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> res){
        if(root == null) return;
        if(res.size() == depth) res.add(0, new ArrayList<Integer>());
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
        res.get(res.size() - depth - 1).add(root.val);
    }
}