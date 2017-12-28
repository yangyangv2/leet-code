package prob452.minimum.number.of.arrows.to.burst.balloons;

import java.util.Arrays;

public class Solution {

    /*
        sort by ending point, shoot at each end position

    */

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] - b[1]);

        if(points.length == 0) return 0;

        int arrows = 1, shootAt = points[0][1];

        for(int i = 1; i < points.length; i ++){
            if(points[i][0] <= shootAt)
                continue;
            arrows ++;
            shootAt = points[i][1];
        }
        return arrows;

    }
}