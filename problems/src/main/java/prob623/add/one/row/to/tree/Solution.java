package prob623.add.one.row.to.tree;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        } else {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<TreeNode> nextLevel = new ArrayList<>();
            TreeNode curNode, newLeft, newRight;
            int depth = 0;

            while(!queue.isEmpty()){
                nextLevel.clear();
                depth ++;
                while(!queue.isEmpty()){
                    curNode = queue.poll();
                    if(depth < d - 1){
                        if(curNode.left != null) nextLevel.add(curNode.left);
                        if(curNode.right != null) nextLevel.add(curNode.right);
                    } else if(depth == d - 1){
                        newLeft = new TreeNode(v);
                        newRight = new TreeNode(v);
                        // watch out
                        newLeft.left = curNode.left;
                        newRight.right = curNode.right;
                        curNode.left = newLeft;
                        curNode.right = newRight;
                    }
                }
                queue.addAll(nextLevel);
            }

            return root;
        }

    }
}
