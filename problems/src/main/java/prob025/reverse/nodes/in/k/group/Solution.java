package prob025.reverse.nodes.in.k.group;

import java.util.List;
import java.util.LinkedList;

/**
 * Created by yanya04 on 7/24/2017.
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

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;


        Solution solution = new Solution();

        ListNode node = solution.reverseKGroup(node1, 2);

        System.out.println(node);
    }

    /*
        Solution1:

        1. two pointers to cut sublists
        2. reverse sublist
    */
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k <= 1) return head;

        SubList probe = new SubList(head, head);
        SubList first = probe;
        ListNode lastTail = null;
        while(probe.tail.next != null){
            if(probe.length == k){
                ListNode next = probe.tail.next;
                probe.tail.next = null;
                probe.reverse();
                if(lastTail != null){
                    lastTail.next = probe.head;
                }
                lastTail = probe.tail;
                probe = new SubList(next, next);
                continue;
            }
            probe.tail = probe.tail.next;
            probe.length += 1;
        }

        if(probe.length == k){
            probe.reverse();
        }

        if(lastTail != null){
            lastTail.next = probe.head;
        }
        return first.head;
    }

    // Sublist maintains a head and tail of a list
    // and also provide a reverse function;
    public static class SubList{
        ListNode head;
        ListNode tail;
        int length = 1;

        public SubList(ListNode head, ListNode tail){
            this.head = head;
            this.tail = tail;
        }

        // reverse the list
        private void reverse(){

            ListNode p = null, q = this.head;
            ListNode t = this.tail;      // swap tail and head
            this.tail = this.head;
            this.head = t;

            while(q != null){
                ListNode temp = q.next;
                q.next = p;                 // reverse pointer
                p = q;                      // move p to next
                q = temp;                   // move q to next;
            }

        }
    }
}
