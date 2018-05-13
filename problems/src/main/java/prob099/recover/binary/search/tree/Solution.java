package prob099.recover.binary.search.tree;

import utils.tree.TreeNode;

import java.util.Stack;

/**
 * Created by yanya04 on 1/8/2018.
 */
public class Solution {
    // inorder traverse
// fix the dis-ordered
    public void recoverTree(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, first = null, second = null, node = null, pre = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                node = stack.pop();

                if (pre != null && pre.val > node.val) {
                    if (first == null) {
                        first = pre;
                    }

                    if (first != null) {
                        second = node;
                    }
                }

                pre = node;
                cur = node.right;
            }
        }

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
