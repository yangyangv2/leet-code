package prob102.binary.tree.level.order.traversal;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yanya04 on 1/8/2018.
 * Modified by yanya04 on 4/23/2018.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0, size = 0;
        TreeNode cur = null;

        while(!queue.isEmpty()){
            size = queue.size();
            depth ++;
            while(size > 0){

                cur = queue.poll();
                size --;
                if(res.size() < depth) res.add(new ArrayList<>());
                res.get(depth - 1).add(cur.val);

                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);

            }
        }
        return res;

    }
}