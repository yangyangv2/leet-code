package prob105.construct.binary.tree.from.preorder.and.inorder.traversal;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 10/7/2017.
 * Modified by yanya04 on 5/18/2018.
 * Modified by yanya04 on 5/21/2018.
 * Modified by yanya04 on 5/29/2018.
 */
public class Solution {
    /*
            A
          B   C
         D E F G

         pre-order: A B D E C F G
         in -order: D B E A F C G

    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        if(preorder.length != inorder.length) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie){

        if(ps > pe || is > ie) return null;

        int pivot = preorder[ps];

        TreeNode root = new TreeNode(pivot);
        int index = is;
        while(index <= ie){
            if(inorder[index] == pivot)
                break;
            index ++;
        }

        int offset = index - is;

        root.left = build(preorder, ps + 1, ps + offset, inorder, is, index - 1);
        root.right = build(preorder, ps + offset + 1, pe, inorder, index + 1, ie);

        return root;
    }

}