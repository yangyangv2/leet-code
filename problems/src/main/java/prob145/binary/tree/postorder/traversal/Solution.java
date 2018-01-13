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
        return iterative(root);
    }
    /*
                     5
                3        8
              2    4    6   9

        post-order:2 4 3 6 9 8 5
        reversed:  5 8 9 6 3 4 2

    */
    private List<Integer> iterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node  = stack.pop();
            result.add(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        Collections.reverse(result);
        return result;
    }


    private List<Integer> recursive(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        postorder(result, root);
        return result;
    }

    /*  LRT
    */
    private void postorder(List<Integer> result, TreeNode node){
        if(node.left != null) postorder(result, node.left);
        if(node.right != null) postorder(result, node.right);
        result.add(node.val);
    }
}
