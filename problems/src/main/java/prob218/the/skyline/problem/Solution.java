package prob218.the.skyline.problem;

import java.util.*;

/**
 * Created by yanya04 on 1/19/2018.
 * Modified by yanya04 on 5/6/2018.
 * Modified by yanya04 on 6/2/2018.
 */
public class Solution {

    /*
    [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8]

    [2,10,0],[3,15,0],[5,12,0],[7,15,1],[9,10,1],[12,12,1],[15,10,0],[19,8,0],[20,10,1],[24,8,1]

    */

    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> res = new ArrayList<>();
        if(buildings == null || buildings.length == 0) return res;

        int n = buildings.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[][] points = new int[2 * n][2];
        int index = 0;
        for(int[] building: buildings){
            points[index ++] = new int[] {building[0], -building[2]};
            points[index ++] = new int[] {building[1], building[2]};
        }
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        // need to handle overlapped time, such as [5,3,0], [5,2,1], or [5,2,1],[5,1,1]

        int prev = 0, cur = 0;
        pq.offer(0);
        for(int i = 0; i < points.length; i ++){

            if(points[i][1] < 0) { //
                pq.offer(-points[i][1]);
            } else {
                pq.remove(points[i][1]);
            }

            cur = pq.peek();

            if(cur != prev){
                res.add(new int[]{ points[i][0], cur });
                prev = cur;
            }
        }

        return res;
    }
}