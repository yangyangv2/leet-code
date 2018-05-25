package prob230.kth.smallest.element.in.a.bst;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 8/18/2017.
 * Modified by yanya04 on 5/24/2018.
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {

        /*
        int count = count(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
*/
        int count = count(root.left);
        if(k <= count){
            return kthSmallest(root.left, k);
        } else if (k > count + 1){
            return kthSmallest(root.right, k - count - 1);
        }
        return root.val;
    }

    private int count(TreeNode root){
        if(root == null) return 0;

        return 1 + count(root.left) + count(root.right);
    }
}