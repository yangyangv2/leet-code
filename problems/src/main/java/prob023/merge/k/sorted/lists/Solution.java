package prob023.merge.k.sorted.lists;

import utils.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yanya04 on 7/23/2017.
 * Modified by yanya04 on 4/29/2018
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        // return pq(lists);

        return merge2by2(lists, 0, lists.length - 1);
    }


    private ListNode merge2by2(ListNode[] lists, int left, int right){

        if(lists.length == 0) return null;

        if(right - left < 2){
            return merge(lists[left], lists[right]);
        }
        // right -left >= 2;
        // 8 - 6 = 2/2 =1 + 6 = 7 => 6,7, 8
        int mid = left + (right - left) / 2;

        return merge(merge2by2(lists, left, mid), merge2by2(lists, mid + 1, right));
    }

    private ListNode merge(ListNode list1, ListNode list2){
        if(list1 == list2) return list1;

        ListNode res = new ListNode(0), cur = res;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if(list1 == null)
            cur.next = list2;
        else
            cur.next = list1;

        return res.next;
    }



    private ListNode pq(ListNode[] lists){

        PriorityQueue<ListNode> pq = new PriorityQueue<>( (n1, n2) -> n1.val - n2.val);
        for(ListNode node: lists){
            if(node != null){
                pq.offer(node);
            }
        }

        ListNode res = new ListNode(0), cur = res;
        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
            if(cur.next != null){
                pq.offer(cur.next);
            }
        }
        return res.next;
    }

}
