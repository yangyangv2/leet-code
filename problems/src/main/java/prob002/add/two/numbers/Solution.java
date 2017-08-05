package prob002.add.two.numbers;

import utils.list.ListNode;

/**
 * Created by yanya04 on 7/22/2017.
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = assembly(new int[] {2, 4, 3});
        ListNode l2 = assembly(new int[] {5, 6, 4});
        ListNode.print(solution.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0); // dummy head
        ListNode node = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null) {sum += l1.val; l1 = l1.next; }
            if(l2 != null) {sum += l2.val; l2 = l2.next; }
            carry = (sum >= 10)? 1 : 0;
            node.next = new ListNode(sum % 10);
            node = node.next;
        }
        if(carry > 0) node.next = new ListNode(carry);
        return dummy.next;
    }


    private static ListNode assembly(int[] nums){
        ListNode head = new ListNode(0);
        ListNode node = head;
        for(Integer num: nums){
            node.next = new ListNode(num);
            node = node.next;
        }
        return head.next;
    }


}
