package prob056.merge.intervals;

import utils.interval.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Modified by yanya04 on 5/12/2018.
 * Modified by yanya04 on 5/18/2018.
 * Modified by yanya04 on 6/10/2018.
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.isEmpty())
            return res;

        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval: intervals){
            if(interval.start > end){
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            } else {
                end = Math.max(interval.end, end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}