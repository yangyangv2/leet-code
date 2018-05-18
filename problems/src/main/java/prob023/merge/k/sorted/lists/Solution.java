package prob023.merge.k.sorted.lists;

import utils.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yanya04 on 7/23/2017.
 * Modified by yanya04 on 4/29/2018.
 * Modified by yanya04 on 5/14/2018.
 * Modified by yanya04 on 5/18/2018.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // return pq(lists);
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi){
        if(lists == null) return null;

        if(lo > hi) return null;        // watch out

        int mid = lo + (hi - lo) / 2;

        if(hi - lo < 2){
            return merge(lists[lo], lists[hi]);
        } else {
            return merge(merge(lists, lo, mid), merge(lists, mid + 1, hi));
        }
    }

    private ListNode merge(ListNode list1, ListNode list2){
        if(list1 == list2)
            return list1;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode res = new ListNode(0), cur = res;
        while(list1 != null && list2!= null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if(list1 != null)
            cur.next = list1;
        else
            cur.next = list2;
        return res.next;
    }

    private ListNode pq(ListNode[] lists){

        ListNode res = new ListNode(0), cur = res;
        if(lists == null) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode list: lists){
            if(list != null)
                pq.offer(list);
        }


        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
            if(cur.next!= null){
                pq.offer(cur.next);
            }
        }
        return res.next;

    }
}
