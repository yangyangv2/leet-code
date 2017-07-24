package prob023.merge.k.sorted.lists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {

    /*
        Complexity:

        Naive:              O(k * n * k)
        Priority Queue:     O(log(k)) * n * k)

    */


    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for(int i = 0; i < lists.length; i ++){
            if(lists[i] != null){
                queue.add(lists[i]);
            }
        }
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            current.next = new ListNode(node.val);
            current = current.next;
            if(node.next != null){
                node = node.next;
                queue.add(node);
            }
        }
        return dummy.next;
    }
}
