package prob654.maximum.binary.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {

/*
    pre-order processing
*/

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxBt(nums, 0, nums.length - 1);
    }

    private TreeNode maxBt(int[] nums, int start, int end){
        if(start > end) return null;
        int max = Integer.MIN_VALUE, maxIndex = 0;
        for(int i = start; i <= end; i ++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maxBt(nums, start, maxIndex - 1);
        root.right = maxBt(nums, maxIndex + 1, end);
        return root;
    }
}
