package prob515.find.largest.value.in.each.tree.row;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {
    /*
        BFS
    */

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while(!queue.isEmpty()){

            List<TreeNode> list = new ArrayList<>();
            while(!queue.isEmpty()){
                list.add(queue.poll());
            }

            int max = Integer.MIN_VALUE;
            for(TreeNode node: list){
                max = Math.max(max, node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}