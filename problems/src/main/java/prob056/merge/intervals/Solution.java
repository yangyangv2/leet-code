package prob056.merge.intervals;

import utils.interval.Interval;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Interval> merge(List<Interval> intervals) {

        int n = intervals.size();
        if(n < 2) return new ArrayList<Interval>(intervals);
        List<Interval> result = new ArrayList<>();

        int[] starts = new int[n];
        int[] ends = new int[n];

        for(int i = 0; i < n; i ++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int index = 0;
        while(index < n){
            int start = starts[index];
            while(index < n - 1 && ends[index] >= starts[index + 1]) index ++;
            int end = ends[index];
            result.add(new Interval(start, end));
            index ++;
        }

        return result;
    }
}
