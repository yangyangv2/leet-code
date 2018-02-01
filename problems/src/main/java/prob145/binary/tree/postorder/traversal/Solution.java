package prob145.binary.tree.postorder.traversal;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by yanya04 on 1/13/2018.
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //return rec(root);
        return iter(root);
    }

    /*
        post-order LRT
    */
    private List<Integer> rec(TreeNode node){
        List<Integer> res = new ArrayList<>();
        helper(node, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> list){
        if(node == null) return ;
        helper(node.left, list);
        helper(node.right, list);
        list.add(node.val);
    }

    /*
        post order -> LRT
        push to stack is TRL
    */
    private List<Integer> iter(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<>();

        stack.push(new Node(root, 1));
        stack.push(new Node(root.right, 0));
        stack.push(new Node(root.left, 0));

        while(!stack.isEmpty()){
            Node node = stack.pop();
            int op = node.op;
            TreeNode tn = node.node;
            if(op == 1){ // tn is not null
                res.add(tn.val);
            } else if (tn != null){
                stack.push(new Node(tn, 1));
                stack.push(new Node(tn.right, 0));
                stack.push(new Node(tn.left, 0));
            }
        }

        return res;
    }

    private static class Node{
        TreeNode node;
        int op;
        Node(TreeNode node, int op){
            this.node = node;
            this.op = op;
        }
    }
}
