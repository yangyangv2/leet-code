package prob732.my.calendar.iii;

import java.util.TreeMap;

/**
 *  Created by yanya04 on 5/23/2018.
 */
public class MyCalendarThree {

    TreeMap<Integer, Integer> treeMap;

    public MyCalendarThree() {
        treeMap = new TreeMap<>();
    }

    public int book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0 ) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0 ) - 1);
        int max = 0, count = 0;
        for(Integer value : treeMap.values()){
            count += value;
            max = Math.max(max, count);
        }
        return max;
    }
}
