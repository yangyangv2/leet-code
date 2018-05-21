package prob105.construct.binary.tree.from.preorder.and.inorder.traversal;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 10/7/2017.
 * Modified by yanya04 on 5/18/2018.
 * Modified by yanya04 on 5/21/2018.
 */
public class Solution {

    /*
    preorder    [3,9,20,15,7]
    inorder     [9,3,15,20,7]

        3
    [9]     [15,20,7]
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length;i ++){
            map.put(inorder[i], i);
        }
        return build(0, 0, inorder.length - 1, preorder, inorder, map);
    }

    private TreeNode build(int p, int lo, int hi, int[] preorder, int[] inorder, Map<Integer, Integer> map){
        if(p >= preorder.length || lo > hi ) return null;

        TreeNode node = new TreeNode(preorder[p]);
        int pivot = map.get(preorder[p]);

        node.left = build(p + 1, lo, pivot - 1, preorder, inorder, map);

        node.right= build(p + pivot - lo + 1, pivot + 1, hi, preorder, inorder, map );

        return node;
    }

}
