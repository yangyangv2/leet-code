package prob146.lru.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 1/14/2018.
 */
public class LRUCache {
    /*
        O(1) operation, then HashMap + DoubledLinkedList
    */
    private static class Node{
        int key;
        int val;
        Node pre;
        Node next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }

    // move node to the tail
    private void touch(Node node){
        if(node == tail)
            return;
        if(node == head){
            removeHead();
        } else {
            // node is not head, therefore node.pre is not null
            node.pre.next = node.next;
            // node is not tail, therefore node.next is not null
            node.next.pre = node.pre;
        }

        // append to tail
        appendTail(node);
    }

    private void removeHead(){
        head = head.next;
        if(head == null)
            tail = null;
        else
            head.pre = null;
    }


    private void appendTail(Node node){
        if(tail == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null)
            return -1;

        touch(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            node.val = value;
            touch(node);
            return;
        }

        if(capacity == 0) {
            if(head == null)
                return;

            // remove head
            map.remove(head.key);
            capacity ++;
            removeHead();
        }
        // append to tail

        node = new Node(key, value);
        appendTail(node);
        map.put(key, node);
        capacity--;
    }
}
