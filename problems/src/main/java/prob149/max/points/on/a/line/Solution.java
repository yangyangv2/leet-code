package prob149.max.points.on.a.line;

import utils.graph.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 1/14/2018.
 */
public class Solution {

/*
    1. calculate slope between two nodes
    2. edge cases:
        1. same points are on the same line
        2. points have the same x axis
    3. accuracy, using gcd to calculate slope
*/

    private int gcd(int a, int b){
        if(a == 0)
            return b;

        return gcd(b % a, a);
    }

    public int maxPoints(Point[] points) {

        if(points == null || points.length ==0)
            return 0;
        if(points.length == 1)
            return 1;

        int max = 1;
        int n = points.length;
        for(int i = 0; i < n; i ++){
            Map<String, Integer> map = new HashMap<>();
            int same = 0;
            int localMax = 1;
            for(int j = 0; j < n; j ++){

                if(i == j) continue;

                Point p1 = points[i];
                Point p2 = points[j];

                if(p1.x == p2.x && p1.y == p2.y){
                    same ++;
                    continue;
                }

                String slope = "#";

                if(p1.x != p2.x){
                    int num1 = p1.x - p2.x;
                    int num2 =p1.y - p2.y;
                    int gcd = gcd(num1, num2);
                    slope = (num2 / gcd) + "/" + (num1 / gcd);
                }

                int count = map.getOrDefault(slope, 1) + 1;
                map.put(slope, count);
                localMax = Math.max(localMax, count);
            }
            max = Math.max(max, localMax + same);
        }
        return max;
    }
}