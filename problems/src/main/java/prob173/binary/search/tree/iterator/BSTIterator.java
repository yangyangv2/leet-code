package prob173.binary.search.tree.iterator;

import utils.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yanya04 on 1/15/2018.
 */
public class BSTIterator {

    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<TreeNode>();
        move(root);
    }

    private void move(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(!hasNext()) return -1;
        TreeNode node = stack.pop();
        move(node.right);
        return node.val;
    }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */