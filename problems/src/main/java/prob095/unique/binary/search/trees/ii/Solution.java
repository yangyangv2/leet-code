package prob095.unique.binary.search.trees.ii;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  Modified by yanya04 on 5/25/2018.
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {

        if(n == 0) return Collections.emptyList();

        int[] nums = new int[n];
        for(int i = 0; i < n; i ++)
            nums[i] = i + 1;
        return backtrack(nums, 0, n - 1);
    }

    private List<TreeNode> backtrack(int[] nums, int lo, int hi){
        List<TreeNode> res = new ArrayList<>();
        if(lo > hi){
            res.add(null);
            return res;
        }

        int val = 0;
        for(int i = lo; i <= hi; i ++){
            val = nums[i];

            List<TreeNode> left = backtrack(nums, lo, i - 1);
            List<TreeNode> right = backtrack(nums, i + 1, hi);

            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode root = new TreeNode(val);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}