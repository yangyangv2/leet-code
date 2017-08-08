package prob108.convert.sorted.array.to.binary.search.tree;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 8/7/2017.
 */
public class Solution {

    /*
        find the middle and break
        inorder-traverse
    */
    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null || nums.length == 0) return null;


        return inorderTraverse(nums, 0, nums.length -1);
    }

    private TreeNode inorderTraverse(int[] nums, int start, int end){

        if(start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode left = inorderTraverse(nums, start, mid - 1);

        TreeNode node = new TreeNode(nums[mid]);

        TreeNode right = inorderTraverse(nums, mid + 1, end);

        node.left = left;
        node.right = right;

        return node;
    }
}
