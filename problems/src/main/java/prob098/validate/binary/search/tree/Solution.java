package prob098.validate.binary.search.tree;

import utils.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yanya04 on 10/1/2017.
 * Modified by yanay04 on 4/23/2018.
 * Modified by yanya04 on 5/14/2018.
 * Modified by yanya04 on 5/18/2018.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isBST(TreeNode node, long max, long min){
        if(node == null) return true;
        if(node.val >= max || node.val <= min) return false;
        return isBST(node.left, node.val, min) && isBST(node.right, max, node.val);
    }
}
