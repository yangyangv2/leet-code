package prob116.populating.next.right.pointers.in.each.node;

import utils.tree.TreeLinkNode;

/**
 * Created by yanya04 on 10/8/2017.
 */
public class Solution {

    public void connect(TreeLinkNode root) {

        if(root == null) return;
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null && root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
