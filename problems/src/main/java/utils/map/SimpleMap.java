package utils.map;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;

public class SimpleMap implements Map{

    private class Node{
        Object key;
        Object val;
        Node next;
        Node(Object key, Object val){
            this.key = key;
            this.val = val;
        }

    }

    private Node[] nodes;

    public SimpleMap(){
        this(16);
    }

    private int capacity;
    public SimpleMap(int capacity){
        nodes = new Node[capacity];
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    private ReadWriteLock readWriteLock;

    @Override
    public Object get(Object key) {
        if(key == null) return null;
        Object res = null;
        try{
            readWriteLock.readLock().lock();
            Node cur = nodes[key.hashCode() % capacity];

            while(cur != null) {
                if (key.equals(cur.key)) {
                    res = cur.val;
                    break;
                }
                cur = cur.next;
            }
        }finally {
            readWriteLock.readLock().unlock();
        }
        return res;
    }

    @Override
    public Object put(Object key, Object value) {
        if(key == null) return null;
        Object res = null;
        try{
            readWriteLock.writeLock().lock();
            Node cur = nodes[key.hashCode() % capacity];
            Node insert = new Node(key, value);
            if(cur != null) {
                insert.next = cur;
            }
            nodes[key.hashCode() % capacity] = insert;
            res = insert.val;
        } finally {
            readWriteLock.writeLock().unlock();
        }
        return res;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
