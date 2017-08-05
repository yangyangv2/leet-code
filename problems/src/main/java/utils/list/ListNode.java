package utils.list;

/**
 * Created by yanya04 on 8/5/2017.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){val = x;}

    public static void print(ListNode node){
        if(node != null){
            System.out.print(node.val + " -> ");
            print(node.next);
        }
    }
}
