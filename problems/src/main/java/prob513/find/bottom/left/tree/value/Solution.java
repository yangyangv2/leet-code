package prob513.find.bottom.left.tree.value;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  Created by yanya04 on 5/13/2018.
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, 0, list);
        return list.isEmpty() ? 0 : list.get(list.size() - 1);
    }

    private void traverse(TreeNode root, int depth, List<Integer> leftMost){

        if(root == null) return ;
        if(depth == leftMost.size()){
            leftMost.add(root.val);
        }

        traverse(root.left, depth + 1, leftMost);
        traverse(root.right, depth + 1, leftMost);
    }
}
