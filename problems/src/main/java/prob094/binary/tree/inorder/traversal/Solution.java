package prob094.binary.tree.inorder.traversal;

import utils.tree.TreeNode;

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yanya04 on 9/3/2017.
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while(cur != null || !stack.isEmpty()){

            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;

    }

    /*

    recursive

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<>();

        traverse(root, list);

        return list;

    }


    private void traverse(TreeNode root, List<Integer> list){

        if(root == null){
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }*/

}
