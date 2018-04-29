package prob206.reverse.linked.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/7/2017.
 * Modified by yanya04 on 4/28/2017
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null, temp = null;

        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }
}
