package prob630.course.schedule.iii;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *  Created by yanya04 on 5/27/2018.
 */
public class Solution {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int time = 0;
        for(int[] course: courses){
            time += course[0];
            pq.offer(course);
            if(time > course[1]){
                time -= pq.poll()[0];
            }
        }

        return pq.size();
    }
}