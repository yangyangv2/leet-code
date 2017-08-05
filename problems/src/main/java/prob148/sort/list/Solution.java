package prob148.sort.list;

/**
 * Created by yanya04 on 8/4/2017.
 */
public class Solution {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }

        @Override
        public String toString(){

            StringBuilder sb = new StringBuilder();
            ListNode node = this;
            do {
                sb.append(node.val).append("->");
                node = node.next;
            }while(node != null);
            return sb.toString();
        }
    }

    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode[] lists = split(head);

        ListNode list1 = lists[0];
        ListNode list2 = lists[1];

        ListNode sorted1 = sortList(list1);
        ListNode sorted2 = sortList(list2);

        return merge(sorted1, sorted2);
    }

    // merge two sorted list
    private ListNode merge(ListNode sorted1, ListNode sorted2){

        ListNode cur = new ListNode(0);
        ListNode head = cur;

        while(sorted1 != null && sorted2 != null){
            if(sorted1.val < sorted2.val){
                cur.next = sorted1;
                sorted1 = sorted1.next;
            } else {
                cur.next = sorted2;
                sorted2 = sorted2.next;
            }
            cur = cur.next;
        }

        if(sorted1 == null) cur.next = sorted2;
        if(sorted2 == null) cur.next = sorted1;

        return head.next;
    }


    // assumption, head list has at least 2 nodes
    private ListNode[] split(ListNode head){
        ListNode[] lists = new ListNode[2];

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        lists[0] = head;
        lists[1] = slow;
        prev.next = null;
        return lists;
    }
}
