package prob146.lru.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 1/14/2018.
 * Modified by yanya04 on 5/14/2018.
 */

public class LRUCache {

    private class Node {
        Node pre, next;
        int key, val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private Map<Integer, Node> map;
    private Node head, tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    // remove head of the list (LRU eviction)
    private Node removeHead(){
        Node temp = head;
        if(head == null)
            return null;
        else if(head.next == null){
            head = null;
            tail = null;
        } else {
            // head.next != null
            head = head.next;
            head.pre = null;
        }
        temp.next = null;
        return temp;
    }

    // append node to the tail
    private void appendTail(Node node){
        if(tail == null){
            head = node;
            node.pre = null;
        } else {
            node.pre = tail;
            tail.next = node;
        }
        tail = node;
        node.next = null;
    }

    // move node to the end of the list
    private void touchNode(Node node){
        if(node == tail){
            return;
        } else if(node == head){
            removeHead();
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        appendTail(node);
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        } else {
            touchNode(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null) {
            node = new Node(key, value);
            map.put(key, node);
            appendTail(node);
            capacity --;
            if(capacity < 0){
                node = removeHead();
                if(node != null){
                    map.remove(node.key);
                }
                capacity ++;
            }
        } else {
            node.val = value;
            touchNode(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */