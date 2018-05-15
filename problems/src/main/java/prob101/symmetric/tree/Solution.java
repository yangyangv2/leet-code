package prob101.symmetric.tree;

import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yanya04 on 9/30/2017.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        // return isSymetric(root.left, root.right);
        return iterative(root);
    }


    private boolean iterative(TreeNode root){

        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;
        queue.offer(root.left);
        queue.offer(root.right);
        TreeNode left = null, right = null;

        while(!queue.isEmpty()){
            size = queue.size();
            while(size > 0){
                left = queue.poll();
                right = queue.poll();
                size -= 2;

                if(left == null && right == null) continue;
                if(left == null || right == null) return false;
                if(left.val != right.val) return false;

                queue.offer(left.left);
                queue.offer(right.right);
                queue.offer(left.right);
                queue.offer(right.left);

            }
        }
        return true;
    }



    private boolean isSymetric(TreeNode left, TreeNode right){

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        if(left.val != right.val) return false;

        return isSymetric(left.left, right.right) && isSymetric(left.right, right.left);
    }
}