package algorithms;

import utils.list.ListNode;

/**
 *  Created by yanya04 on June 10
 *
 *  Doubly linked list to balanced binary search tree
 *
 */
public class Dll2Bst {
    public ListNode head, tail, root;
    public int size = 0;
    // build up list similar to add(0, value);
    public void add(int data) {
        ListNode n = new ListNode(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            head.prev = n;
            n.next = head;
            head = n;
        }
        size++;
    }

    public void printDLL(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(" " + curr.val);
            curr = curr.next;
        }
        System.out.println();
    }





    public ListNode dll2bst(int size) {
        if (size <= 0) {
            return null;
        }
        ListNode left = dll2bst(size / 2);
        ListNode root = head;
        root.prev = left;
        head = head.next;
        root.next = dll2bst(size-(size / 2)-1);
        return root;
    }

    public void inOrder(ListNode root) {
        if (root != null) {
            inOrder(root.prev);
            System.out.print(" " + root.val);
            inOrder(root.next);
        }
    }


    public static void main(String args[]) {
        Dll2Bst r = new Dll2Bst();
        for(int i = 29 ; i > 0; i --) r.add(i);
        ListNode h = r.head;
        System.out.println("DLL is : ");
        r.printDLL(h);
        ListNode x = r.dll2bst(r.size);
        System.out.println("Inorder traversal of contructed BST");
        r.inOrder(x);
    }
}
