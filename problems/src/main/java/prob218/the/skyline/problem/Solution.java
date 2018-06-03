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

        int[][] points = new int[2 * n][3];
        int index = 0;
        for(int[] building: buildings){
            points[index ++] = new int[] {building[0], building[2], 0};
            points[index ++] = new int[] {building[1], building[2], 1};
        }
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        // need to handle overlapped time, such as [5,3,0], [5,2,1], or [5,2,1],[5,1,1]

        // time
        // height
        // start/stop
        //
        // [2,10,0],[3,15,0],[5,12,0],[7,15,1],[9,10,1],[12,12,1],[15,10,0],[19,8,0],[20,10,1],[24,8,1]

        int maxLevel = 0, curLevel = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i = 0; i < points.length; i ++){

            if(points[i][2] == 0){ // start, add height into map
                tm.put(points[i][1], tm.getOrDefault(points[i][1], 0) + 1);
            }

            if(points[i][2] == 1){ // end, remove height from the map
                tm.put(points[i][1], tm.getOrDefault(points[i][1], 0) - 1);
                if(tm.get(points[i][1]) <= 0){
                    tm.remove(points[i][1]);
                }
            }

            // skip two starts at the same time, do nothing
            if(i < points.length - 1 && points[i][0] == points[i + 1][0])
                continue;

            curLevel = tm.isEmpty() ? 0 : tm.lastKey();

            if(maxLevel != curLevel){
                res.add(new int[]{ points[i][0], curLevel });
                maxLevel = curLevel;
            }
        }

        return res;
    }
}