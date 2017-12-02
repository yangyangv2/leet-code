package prob095.unique.binary.search.trees.ii;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
        n = 3 => [1, 2, 3]

        f([1,2,3]) = f([1,2]) + f([2,3]) + f([1,3]);

    */

    public List<TreeNode> generateTrees(int n) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i ++){
            nums[i] = i + 1;
        }
        return helper(nums, 0, n - 1);
    }

    private List<TreeNode> helper(int[] nums, int start, int end){;

        List<TreeNode> res = new ArrayList<>();
        for(int i = start; i <= end; i ++){
            int next = nums[i];

            List<TreeNode> left = helper(nums, start, i - 1);
            List<TreeNode> right = helper(nums, i + 1, end);

            if(left.isEmpty())
                left.add(null);

            if(right.isEmpty())
                right.add(null);

            for(TreeNode l: left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(next);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}