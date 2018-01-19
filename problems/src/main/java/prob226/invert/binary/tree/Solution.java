package prob226.invert.binary.tree;

import utils.tree.TreeNode;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yanya04 on 1/19/2018.
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
    public TreeNode invertTree(TreeNode root) {
        return iterative(root);
    }


    private TreeNode iterative(TreeNode root){
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return root;
    }

    private TreeNode recursive(TreeNode root){
        if(root == null) return root;
        TreeNode left = recursive(root.left);
        TreeNode right = recursive(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
