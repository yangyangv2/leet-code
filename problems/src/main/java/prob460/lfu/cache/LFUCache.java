package prob460.lfu.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yanya04 on 1/14/2018.
 */
public class LFUCache {

    private static class Node {
        int count;
        int key;
        int val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }

    private Map<Integer, Node> map;
    private Map<Integer, Set<Integer>> level;
    private int capacity;
    private int min = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.level = new HashMap<Integer, Set<Integer>>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null)
            return -1;

        level.get(node.count).remove(key);
        if(node.count == min && level.get(node.count).isEmpty())
            min ++;

        node.count ++;
        Set<Integer> set = level.get(node.count);
        if(set == null){
            set = new LinkedHashSet<Integer>();
            level.put(node.count, set);
        }
        set.add(key);
        return node.val;
    }

    public void put(int key, int value) {

        Node node = map.get(key);
        if(node != null){
            node.val = value;
            get(key);
            return;
        }

        if(capacity == 0){
            if(map.isEmpty())
                return;
            int evit = level.get(min).iterator().next();
            level.get(min).remove(evit);
            map.remove(evit);
            capacity ++;
        }

        map.put(key, new Node(key, value));
        capacity --;
        Set<Integer> set = level.get(1);
        if(set == null){
            set = new LinkedHashSet<Integer>();
            level.put(1, set);
        }
        set.add(key);
        min = 1;

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
