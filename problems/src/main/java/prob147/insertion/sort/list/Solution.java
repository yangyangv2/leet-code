package prob147.insertion.sort.list;

import utils.list.ListNode;

/**
 * Created by yanya04 on 8/8/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();


        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for(Integer i : new int[]{4,19,14,-3}) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode.print(solution.insertionSortList(dummy.next));
    }


    public ListNode insertionSortList(ListNode head) {

/*
        insersion sort
        for(i = 0; i < list.length; i ++){
            for(j = 0; j < i; j ++){
                if(a[i] < a[j] ){
                    insert a[i] between a[j-1], a[j]
                }
            }

        }

        X->1->3->5->3->2->Null
        s->
        p->c->

        X->1->3->5->3->2->Null
        s->
              p->c->

        foreach c
            foreach p to c
                if(p > c)
                    insert c before p

        Test1:  null
        Test2: X->1->
        Test3: X->1->2->
               s
                  p
                     c
        Test4: X->2->1->
               s
               p
                  c
        1ist:  X->1->2->
               s
                  p
                     c

        Test5: X->2->1->3->
               s
               p
                  c
        1ist:  X->1->2->3->
               s
                     p
                     c

        Test6: X->3->2->1->
               s
               p
                  c
        1ist:  X->2->3->1->
               s
                  p
                     c
        2ist:  X->3->2->1->
               s
               p
                  c

               X->2->3->1->
               s
               p
                     c

               X->1->2->3-null
               s
               p
                        c

*/
        if(head == null || head.next == null) return head;

        ListNode s = new ListNode(0);
        s.next = head;

        ListNode p, c;
        c = s.next;

        while(c.next != null){
            p = s;

            ListNode.print(s.next);
            System.out.println();
            while(c.next != null && p.next != c.next){
                if(p.next.val > c.next.val){
                    // insert c.next into p.next;
                    ListNode tmp1 = p.next;         // 2
                    ListNode tmp2 = c.next.next;    // null
                    p.next = c.next;                // X->1-null
                    c.next = tmp2;                  // 3->null
                    p.next.next = tmp1;             // X->1->2->3-null
                    p = s;
                } else {
                    p = p.next;
                }
            }
            c = c.next;
            if(c == null) break;
        }
        return s.next;


    }
}
