package prob106.construct.binary.tree.from.inorder.and.postorder.traversal;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 10/8/2017.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++)
            map.put(inorder[i], i);

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map){
        if(is > ie || ps > pe) return null;

        int postValue = postorder[pe];
        TreeNode node = new TreeNode(postValue);
        int inIndex = map.get(postValue);

        node.left = helper(inorder, is, inIndex -1, postorder, ps, ps + inIndex - is - 1, map);
        node.right = helper(inorder, inIndex + 1, ie, postorder, ps + inIndex - is, pe - 1, map);

        return node;
    }

}