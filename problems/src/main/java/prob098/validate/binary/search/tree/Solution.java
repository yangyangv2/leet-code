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
 * Modified by yanya04 on 6/10/2018.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    private boolean isValidBST(TreeNode node, long min, long max){

        if(node == null) return true;

        if(node.val <= min || node.val >= max)
            return false;

        return isValidBST(node.left, min, (long)node.val) && isValidBST(node.right, (long)node.val, max);
    }
}
