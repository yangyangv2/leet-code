package prob098.validate.binary.search.tree;

import utils.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yanya04 on 10/1/2017
 * Modifed by yanay04 on 4/23/2018
 */
public class Solution {


    private boolean isBst(TreeNode root, long max, long min){
        if(root == null) return true;
        if(root.val >= max || root.val <= min) return false;
        return isBst(root.left, root.val, min) && isBst(root.right, max, root.val);
    }

    private boolean recursive(TreeNode root){
        return isBst(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean iterative(TreeNode root){
        TreeNode cur = root, node = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Integer pre = null;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                node = stack.pop();

                if(pre == null){
                    pre = node.val;
                } else if(pre < node.val){
                    pre = node.val;
                } else {
                    return false;
                }

                cur = node.right;
            }
        }
        return true;
    }


    public boolean isValidBST(TreeNode root) {

        return recursive(root);
        //return iterative(root);
    }
}
