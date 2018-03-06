package prob380.insert.delete.getrandom.o1;

import java.util.*;

/**
 * Created by yanya04 on 2/24/2018.
 */
public class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private int nextValid;
    private Random rand;


    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        if(nextValid < list.size())
            list.set(nextValid, val);
        else
            list.add(val);

        map.put(val, nextValid);
        nextValid ++;

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int removed = map.remove(val);

        if(removed < nextValid - 1) {
            int last = list.get(nextValid - 1);
            list.set(removed, last);
            map.put(last, removed);
        }

        nextValid --;

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(nextValid == 0)
            return 0;
        int random = rand.nextInt(nextValid);
        return list.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
