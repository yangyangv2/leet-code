package prob296.best.meeting.point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yanya04 on 2/5/2018.
 */
public class Solution {
    /*
        if x is the median then sum of | x - xi | is minimum, given x belongs to (x1, x2 ... xi ... xn)
        A .... B ....C ....D ... E ...F


        you want to find a point which the sum of the distance to any points, can be minimized.


    */
    public int minTotalDistance(int[][] grid) {

        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;

        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();

        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == 1){
                    xs.add(i);
                    ys.add(j);
                }
            }

        return calculateMin(xs) + calculateMin(ys);

    }

    private int calculateMin(List<Integer> list){
        Collections.sort(list);

        // the minimum deviation is calculated as
        int i = 0, j = list.size() - 1;
        int sum = 0;
        while(i < j){
            sum += (list.get(j --) - list.get(i ++));
        }
        return sum;
    }


}
