package prob253.meeting.rooms.ii;

import utils.interval.Interval;

import java.util.Arrays;

public class Solution {
    public int minMeetingRooms(Interval[] intervals) {

        if(intervals  == null) return 0;
        int n = intervals.length;
        if(n == 0) return 0;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for(int i = 0; i < n; i ++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts); Arrays.sort(ends);

        int rooms = 0;
        int lastIndex = 0;
        for(int i = 0; i < n; i ++){
            if(starts[i] < ends[lastIndex]){
                rooms ++;
            } else {
                lastIndex ++;
            }
        }
        return rooms;
    }
}