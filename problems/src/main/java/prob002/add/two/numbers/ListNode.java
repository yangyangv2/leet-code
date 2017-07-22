package prob002.add.two.numbers;

/**
 * Created by yanya04 on 7/22/2017.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void print(ListNode node){
        if(node != null){
            System.out.print(node.val + " -> ");
            print(node.next);
        }
    }
}
