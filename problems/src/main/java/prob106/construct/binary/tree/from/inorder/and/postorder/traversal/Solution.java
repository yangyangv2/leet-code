package prob106.construct.binary.tree.from.inorder.and.postorder.traversal;

import utils.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 10/8/2017.
 * Modified by yanya04 on 5/29/2018.
 */
public class Solution {
    /*
            A
          B   C
         D E F G

        post-order: D E B F G C A
          in-order: D B E A F C G
                    |-----|
                    offset
    */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        if(inorder.length != postorder.length) return null;
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int ps, int pe, int[] inorder, int is, int ie){
        if(ps > pe || is > ie) return null;
        int pivot = postorder[pe];
        TreeNode root = new TreeNode(pivot);
        int index = is;
        while(index <= ie){
            if(inorder[index] == pivot)
                break;
            index ++;
        }
        int offset = index - is;
        root.left = build(postorder, ps, ps + offset - 1, inorder, is, index - 1);
        root.right = build(postorder, ps + offset, pe - 1, inorder, index + 1, ie);
        return root;
    }


}