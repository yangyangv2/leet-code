package prob094.binary.tree.inorder.traversal;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yanya04 on 9/3/2017.
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return iterative(root);
    }

    private List<Integer> recursive(TreeNode root){
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> list){
        if (node == null) {
            return;
        }
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }


    private class Node{
        TreeNode node;
        int op;         // 1 insert, 0
        public Node(TreeNode node, int op){
            this.node = node;
            this.op = op;
        }
    }

    /*
        simulate stack operation
        in-order traverse, LTR
        push order: RTL
    */
    private List<Integer> iterative(TreeNode root){

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<Node> stack = new Stack<>();

        stack.push(new Node(root.right, 0));    // R
        stack.push(new Node(root, 1));          // T
        stack.push(new Node(root.left, 0));     // L

        while(!stack.isEmpty()){
            Node node = stack.pop();
            int op = node.op;
            TreeNode tn = node.node;
            if(op == 1){
                result.add(node.node.val);
            } else if(tn != null){
                stack.push(new Node(tn.right, 0));  // R
                stack.push(new Node(tn, 1));        // T
                stack.push(new Node(tn.left, 0));   // L
            }
        }
        return result;
    }
}
