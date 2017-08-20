package prob270.closest.binary.search.tree.value;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 8/19/2017.
 */
public class Solution {
    private int closestValue = -1;

    public int closestValue(TreeNode root, double target) {
        closestValue = root.val;
        findCloset(root, target);
        return closestValue;
    }


    private void findCloset(TreeNode root, double target){
        if(root == null){
            return;
        }

        if(target < root.val){
            findCloset(root.left, target);
        } else {
            findCloset(root.right, target);
        }

        if(Math.abs(root.val - target) < Math.abs(closestValue - target)){
            closestValue = root.val;
        }

    }
}
