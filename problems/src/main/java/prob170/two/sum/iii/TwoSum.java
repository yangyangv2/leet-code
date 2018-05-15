package prob170.two.sum.iii;

import java.util.*;

/**
 * Created by yanya04 on 8/9/2017.
 * Modified by yanya04 on 5/14/2018.
 *
 */
public class TwoSum {

    /** Initialize your data structure here. */


    private Map<Integer, Integer> map;
    private List<Integer> list;

    public TwoSum() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(! map.containsKey(number)){
            map.put(number, 1);
            list.add(number);
        } else {
            map.put(number, 2);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int num = 0;
        for(int i = 0; i < list.size(); i ++){
            num = list.get(i);
            if(value - num == num && map.get(num) > 1) return true;
            if(value - num != num && map.containsKey(value - num)) return true;
        }
        return false;
    }
}
