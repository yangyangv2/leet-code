package prob173.binary.search.tree.iterator;

import utils.tree.TreeNode;

import java.util.Stack;

/**
 * Created by yanya04 on 1/15/2018.
 */
public class BSTIterator {

    private TreeNode root;
    private TreeNode next;
    private Stack<TreeNode> stack;


    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        next = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return next != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {

        while(next != null){
            stack.push(next);
            next = next.left;
        }

        next = stack.pop();
        int res = next.val;
        next = next.right;
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */