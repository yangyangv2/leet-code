package prob102.binary.tree.level.order.traversal;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yanya04 on 1/8/2018.
 * Modified by yanya04 on 4/23/2018
 */
public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
        BFS
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        queue.offer(root);
        int level = 0, levelSize = 0;
        TreeNode next = null;
        while(!queue.isEmpty()){
            res.add(new ArrayList<>());
            levelSize = queue.size();
            while(levelSize -- > 0){
                next = queue.poll();
                res.get(level).add(next.val);
                if(next.left != null) queue.offer(next.left);
                if(next.right != null) queue.offer(next.right);
            }
            // prepare for the next level;
            level ++;
        }
        return res;
    }
}
