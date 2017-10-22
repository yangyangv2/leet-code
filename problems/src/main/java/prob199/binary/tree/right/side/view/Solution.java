package prob199.binary.tree.right.side.view;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 10/22/2017.
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list, 0);
        return list;
    }

    private void traverse(TreeNode node, List<Integer> list, int depth){

        if(node == null) return;

        if(list.size() < depth + 1){
            list.add(node.val);
        } else {
            list.set(depth, node.val);
        }

        traverse(node.left, list, depth + 1);

        traverse(node.right, list, depth + 1);
    }

}
