package prob252.meeting.rooms;

import utils.interval.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {

    public boolean canAttendMeetings(Interval[] intervals) {

        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval t1, Interval t2){
                return t1.start - t2.start;
            }
        });

        for(int i = 0; i < intervals.length - 1; i ++){
            if(intervals[i].end > intervals[i + 1].start)
                return false;
        }
        return true;
    }
}