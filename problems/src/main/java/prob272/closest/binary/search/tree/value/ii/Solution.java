package prob272.closest.binary.search.tree.value.ii;

import utils.tree.TreeNode;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yanya04 on 1/25/2018.
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        return onSolution(root, target , k);
    }


    private List<Integer> onSolution(TreeNode root, double target, int k){
        LinkedList<Integer> res = new LinkedList<>();
        inorder(k, target, root, res, false);
        return res;
    }

    private void inorder(int k, double target, TreeNode root, Queue<Integer> res, boolean finish){
        if(finish || root == null)
            return;
        inorder(k, target, root.left, res, finish);
        if(res.size() < k){
            res.offer(root.val);
        } else {
            if(Math.abs(root.val - target) < Math.abs(target - res.peek())){
                res.poll();
                res.offer(root.val);
            } else {
                finish = true;
            }
        }
        inorder(k, target, root.right, res, finish);
    }
}
