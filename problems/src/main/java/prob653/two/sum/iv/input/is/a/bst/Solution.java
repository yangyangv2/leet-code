package prob653.two.sum.iv.input.is.a.bst;

import utils.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 8/14/2017.
 * Modified by yanya04 on 6/1/2018.
 */
public class Solution {
    private Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {

        if(root == null) return false;

        if(findTarget(root.left, k)) return true;

        if(set.contains(k - root.val)) return true;

        set.add(root.val);

        return findTarget(root.right, k);
    }
}