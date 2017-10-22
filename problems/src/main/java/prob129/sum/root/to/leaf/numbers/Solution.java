package prob129.sum.root.to.leaf.numbers;

import utils.tree.TreeNode;

/**
 * Created by yanya04 on 10/21/2017.
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int sum){
        if(node == null) return 0;
        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null) return sum;
        else return sum(node.left, sum) + sum(node.right, sum);
    }
}
