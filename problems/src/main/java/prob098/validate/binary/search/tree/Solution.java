package prob098.validate.binary.search.tree;

import utils.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yanya04 on 10/1/2017
 * Modified by yanay04 on 4/23/2018
 * Modified by yanya04 on 5/14/2018
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode cur = root, node = null, pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                node = stack.pop();
                if(pre != null && !(node.val > pre.val)) return false;
                pre = node;
                cur = node.right;
            }
        }
        return true;
    }
}
