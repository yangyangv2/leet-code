package prob057.insert.interval;

import utils.interval.Interval;

import java.util.ArrayList;
import java.util.List;

public /**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    /*
                               s        e
        [beining intervals ..]   s1 e1 s2      e2   s2    [remaining intervals ]

    */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        List<Interval> result = new ArrayList<>();
        if(n == 0){
            result.add(newInterval);
            return result;
        }

        int index = 0;
        // add the begining elements
        while(index < n && intervals.get(index).end < newInterval.start) {
            result.add(intervals.get(index ++));
        }

        // if newInterval should be appended at tail
        if(index == n) {
            result.add(newInterval);
            return result;
        }

        // merge new Interval;
        newInterval.start = Math.min(newInterval.start,intervals.get(index).start);
        while(index < n && intervals.get(index).start <= newInterval.end){
            newInterval.end = Math.max(newInterval.end, intervals.get(index++).end);
        }
        result.add(newInterval);

        // add the remaining elements
        while(index < n){
            result.add(intervals.get(index++));
        }

        return result;
    }


}