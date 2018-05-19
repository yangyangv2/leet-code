package prob105.construct.binary.tree.from.preorder.and.inorder.traversal;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 10/7/2017.
 * Modified by yanya04 on 5/18/2018.
 */
public class Solution {

    /*
    preorder    [3,9,20,15,7]
    inorder     [9,3,15,20,7]

        3
    [9]     [15,20,7]
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode build(int p, int lo, int hi, int[] preorder, int[] inorder){
        if(p >= preorder.length || lo > hi ) return null;

        TreeNode node = new TreeNode(preorder[p]);
        int pivot = -1;
        for(int i = lo; i <= hi; i ++){
            if(preorder[p] == inorder[i]){
                pivot = i;
                break;
            }
        }

        node.left = build(p + 1, lo, pivot - 1, preorder, inorder );
        node.right= build(p + pivot - lo + 1, pivot + 1, hi, preorder, inorder );

        return node;
    }

}
