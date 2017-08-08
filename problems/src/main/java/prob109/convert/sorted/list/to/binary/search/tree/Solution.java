package prob109.convert.sorted.list.to.binary.search.tree;

import utils.list.ListNode;
import utils.tree.TreeNode;

/**
 * Created by yanya04 on 8/7/2017.
 */
public class Solution {
    private ListNode probe;

    public TreeNode sortedListToBST(ListNode head) {
/*
        use binary break down
        use LTR recursive traverse

        1 2 3 4 5 6 7       (counter = 7)
        1 2 3 4 5 6 7 8     (counter = 8)

*/
        if(head == null) return null;

        ListNode cur = head;
        int counter = 0;
        while(cur != null){
            counter ++;
            cur = cur.next;
        }

        probe = head;
        return inorderTraverse(0, counter - 1);             //  [0,6]
        //  [0,7]
    }

    private TreeNode inorderTraverse(int start, int end){
        if(start > end || probe == null) return null;

        int mid = start + (end - start) /2;
        TreeNode left = inorderTraverse(start, mid -1);     //  [0,2]  -> [0,0],[1],[2,2] -> 1 2, 3
        //  [0,2]  -> [0,0],[1],[2,2]

        TreeNode node = new TreeNode(probe.val);            //  [3]     4
        probe = probe.next;

        TreeNode right = inorderTraverse(mid + 1, end);     //  [4,7]  -> [4,4],[5],[6,7] -> [4,4],[5],[6],[7,7]

        node.left = left;
        node.right = right;

        return node;
    }
}
