package prob102.binary.tree.level.order.traversal;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yanya04 on 1/8/2018.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // return preorder(root);
        return interative(root);
    }

    private List<List<Integer>> interative(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            result.add(list);
        }
        return result;
    }




    private List<List<Integer>> preorder(TreeNode root){
        List<List<Integer>> orders = new ArrayList<>();

        traverse(orders, root, 0);

        return orders;
    }


    /*  pre-order traverse
    */
    private void traverse(List<List<Integer>> orders, TreeNode node, int depth){

        if(node == null)
            return;

        if(orders.size() == depth){
            orders.add(new ArrayList<Integer>());
        }

        orders.get(depth).add(node.val);

        traverse(orders, node.left, depth + 1);
        traverse(orders, node.right, depth + 1);


    }
}
