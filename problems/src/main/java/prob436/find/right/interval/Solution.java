package prob436.find.right.interval;

import utils.interval.Interval;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yanya04 on 8/26/2017.
 */
class Solution {

/*
    solution TreeMap

*/
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            tree.put(intervals[i].start, i);
        }
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = tree.ceilingEntry(intervals[i].end);
            if (entry == null) {
                result[i] = -1;
            } else {
                result[i] = entry.getValue();
            }
        }
        return result;
    }
}
