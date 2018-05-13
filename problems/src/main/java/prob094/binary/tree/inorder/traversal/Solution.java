package prob094.binary.tree.inorder.traversal;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by yanya04 on 9/3/2017.
 * Modified by yanya04 on 5/13/2018.
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root, node = null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(cur != null || !stack.isEmpty()){
            if(cur != null ){
                stack.push(cur);
                cur = cur.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                cur = node.right;
            }
        }
        return res;
    }
}
