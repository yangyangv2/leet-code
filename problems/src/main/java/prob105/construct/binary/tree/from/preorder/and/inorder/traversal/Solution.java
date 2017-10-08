package prob105.construct.binary.tree.from.preorder.and.inorder.traversal;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 10/7/2017.
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // value, index
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i ++)
            map.put(inorder[i], i);


        return helper(0, 0, inorder.length - 1, preorder, inorder, map);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> map){

        if(preStart >= preorder.length || inStart > inEnd) return null;
        int preValue = preorder[preStart];
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = map.get(preValue);

        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder, map);

        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, map);

        return root;
    }
}
