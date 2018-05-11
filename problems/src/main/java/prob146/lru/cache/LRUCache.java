package prob146.lru.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 1/14/2018.
 */

public class LRUCache {


    // 1. need a map for fast access on value
    // 2. need a double linked list to keep track of the least recently used

    // map = { key1=>Node1, key2=>Node2 }
    // list= {         +------------+   }
    //                head         tail
    //                least        most

    // for put:
    //      1. add into the map
    //      2. if already in, update and move item to tail
    //         if not in, append at the tail

    // for get:
    //      1. get from map
    //      2. move the node to the tail

    // for eviction
    //      1. delete from the map
    //      2. remove from the head


    /*
        ["LRUCache","put","put","get","put","get","put","get","get","get"]
        [[2],       [1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    private void touch(Node res){

        if(res == tail){
            return;
        } else if(res == head){
            removeHead();
        } else {
            res.pre.next = res.next;
            res.next.pre = res.pre;
        }
        appendTail(res);
    }


    private Node removeHead(){
        Node remove = head;
        if(head == null)
            return remove;
        if(head.next == null){
            head = null;
            tail = null;
            return remove;
        }
        head = head.next;
        head.pre = null;
        return remove;
    }

    private void appendTail(Node node){
        node.next = null;
        if(tail == null){
            head = node;
            node.pre = null;
        } else {
            tail.next = node;
            node.pre = tail;
        }
        tail = node;
    }


    public int get(int key) {
        Node res = map.get(key);
        if(res == null) return -1;

        // move node to the tail (touch)
        touch(res);
        return res.val;
    }

    public void put(int key, int value) {

        Node res = map.get(key);
        if(res == null){
            res = new Node(key, value);
            map.put(key, res);
            appendTail(res);
            capacity --;
        } else {
            res.val = value;
            touch(res);
        }

        if(capacity < 0){
            Node remove = removeHead();
            if(remove != null) {
                map.remove(remove.key);
                capacity ++;
            }
        }
    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;
    private static class Node {
        int val;
        int key;
        Node pre;
        Node next;
        Node(int key, int val){
            this.val = val;
            this.key = key;
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */