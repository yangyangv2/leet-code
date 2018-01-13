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
        //return recursive(root);
        return iterative(root);
    }

    private List<Integer> iterative(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return list;
    }

    private List<Integer> recursive(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preorder(list, root);
        return list;
    }

    private void preorder(List<Integer> list, TreeNode node){
        if(node == null)
            return;
        list.add(node.val);
        preorder(list, node.left);
        preorder(list, node.right);
    }
}
