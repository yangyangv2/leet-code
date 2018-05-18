package prob671.second.minimum.node.in.a.binary.tree;

import utils.tree.TreeNode;

import java.util.Stack;
import java.util.TreeSet;

/**
 * Created by yanya04 on 1/21/2018.
 * Modified by yanya04 on 5/16/2018.
 * Modified by yanya04 on 5/17/2018.
 */
public class Solution {

    private int iterative(TreeNode root){
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        TreeNode cur = root, node = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeSet<Integer> set = new TreeSet<>();

        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                node = stack.pop();
                set.add(node.val);
                cur = node.right;
            }
        }
        if(set.isEmpty()) return -1;
        set.remove(set.first());
        return set.isEmpty()? -1: set.first();
    }

    private int recursive(TreeNode root){
        if(root == null || (root.left == null && root.right == null))
            return -1;

        int left = root.left.val;
        int right = root.right.val;

        if(left == root.val){
            left = recursive(root.left);
        }
        if(right == root.val){
            right = recursive(root.right);
        }

        if(left == -1 && right == -1)
            return -1;
        if(left == -1) return right;
        if(right == -1) return left;
        return Math.min(left, right);
    }

    public int findSecondMinimumValue(TreeNode root) {

        return recursive(root);
    }
}