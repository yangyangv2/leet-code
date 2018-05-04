package prob103.binary.tree.zigzag.level.order.traversal;

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

    private void bfs(TreeNode root, List<List<Integer>> result){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level ++;
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            // if even level, reverse;
            if(level % 2 == 0){
                Collections.reverse(list);
            }
            result.add(list);
        }
    }
    private void dfs(TreeNode root, List<List<Integer>> res, int level){

        if(root == null) return;
        if(res.size() == level) res.add(new ArrayList<Integer>());

        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);

        if((level & 1) == 1) // odd
            res.get(level).add(0, root.val);
        else
            res.get(level).add(root.val);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        bfs(root, result);
        return result;
    }
}
