package prob653.two.sum.iv.input.is.a.bst;

import utils.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 8/14/2017.
 */
public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();

        return traverse(root, k, set);

    }

    private boolean traverse(TreeNode root, int k, Set<Integer> set){
        if(root == null){
            return false;
        }

        boolean result = traverse(root.left, k, set);

        if(result){
            return true;
        }

        if(set.contains(root.val)){
            return true;
        }

        set.add(k - root.val);

        result = traverse(root.right, k, set);


        return result;
    }
}
