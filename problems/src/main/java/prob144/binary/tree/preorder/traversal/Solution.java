package prob144.binary.tree.preorder.traversal;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yanya04 on 1/13/2018.
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // return recursive(root);
        return iterative(root);
    }

    private List<Integer> recursive(TreeNode root){
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    /*
        pre-order: TLR
    */
    private void helper(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

    /*
        Node class is used to persist the operation state
        of each processed TreeNode
    */
    private static class Node{
        TreeNode node;
        int op;
        Node(TreeNode node, int op){
            this.node = node;
            this.op = op;       // 1 insert, 0 nothing
        }
    }
    /*
        using stack to iterative preorder traverse
        the preorder sequence is TLR
        so the stack push order is RLT
    */
    private List<Integer> iterative(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<Node> stack = new Stack<>();

        stack.push(new Node(root.right, 0));
        stack.push(new Node(root.left, 0));
        stack.push(new Node(root, 1));

        while(!stack.isEmpty()){

            Node node = stack.pop();
            int op = node.op;
            TreeNode tn = node.node;

            if(op == 1){ // insert and tn must not be null
                res.add(tn.val);
            } else if(tn != null){ // another RLT
                stack.push(new Node(tn.right, 0));
                stack.push(new Node(tn.left, 0));
                stack.push(new Node(tn, 1));
            }
        }

        return res;
    }
}
