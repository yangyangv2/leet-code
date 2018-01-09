package prob099.recover.binary.search.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/8/2018.
 */
public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private TreeNode first, second;
    private TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    private void inorder(TreeNode root){


        if(root == null) return;

        inorder(root.left);

        if(first == null && pre.val > root.val){
            first = pre;
        }

        if(first != null && pre.val > root.val){
            second = root;
        }

        pre = root;

        inorder(root.right);


    }
}
