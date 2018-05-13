package prob145.binary.tree.postorder.traversal;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by yanya04 on 1/13/2018.
 * Modified by yanya04 on 5/13/2018.
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root, node = null;
        while(cur != null || ! stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                res.add(cur.val);
                cur = cur.right;
            } else {
                node = stack.pop();
                cur = node.left;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
