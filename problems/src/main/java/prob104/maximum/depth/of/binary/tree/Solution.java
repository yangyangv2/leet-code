package prob104.maximum.depth.of.binary.tree;

import utils.tree.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {

        int max = 0, depth = 0;
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();


        // in-order

        /*
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                depth ++;
                count.push(depth);
                max = Math.max(max, depth);
                root = root.left;
            }
            root = stack.pop();
            depth = count.pop();
            root = root.right;
        }*/

        // pre order

        /*
        stack.push(root);
        count.push(0);
        depth = 0;
        while(!stack.isEmpty()){
            root = stack.pop();
            depth = count.pop() + 1;
            max = Math.max(max, depth);
            if(root.left != null) {
                stack.push(root.left);
                count.push(depth);
            };
            if(root.right != null) {
                stack.push(root.right);
                count.push(depth);
            };
        }

        */

        // post order
        stack.push(root);
        count.push(0);
        depth = 0;
        while(!stack.isEmpty()){
            root = stack.pop();
            depth = count.pop() + 1;
            max = Math.max(max, depth);
            if(root.right != null) {
                stack.push(root.right);
                count.push(depth);
            };
            if(root.left != null) {
                stack.push(root.left);
                count.push(depth);
            };
        }

        return max;
    }
}