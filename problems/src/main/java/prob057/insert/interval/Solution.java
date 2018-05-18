package prob057.insert.interval;

import utils.interval.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 *  Modified by yanya04 on 5/16/2018.
 */
public class Solution {

    /*
      [1,2]     [3,5]   [6,8]
              [   ]
    */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int index = 0;
        // add before
        while(index < intervals.size() && intervals.get(index).end < newInterval.start) res.add(intervals.get(index ++));

        int start = newInterval.start, end = newInterval.end;
        while(index < intervals.size() && intervals.get(index).start <= newInterval.end ){
            start = Math.min(intervals.get(index).start, start);
            end = Math.max(intervals.get(index).end, end);
            index ++;
        }
        res.add(new Interval(start, end));
        while(index < intervals.size()) res.add(intervals.get(index ++));
        return res;
    }
}