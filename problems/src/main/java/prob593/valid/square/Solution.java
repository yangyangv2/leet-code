package prob593.valid.square;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 6/1/2018.
 */
public class Solution {
    /*
          1
        1   1
          1

    */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();

        set.add(dist(p1, p2));
        set.add(dist(p2, p3));
        set.add(dist(p3, p4));
        set.add(dist(p1, p4));
        set.add(dist(p2, p4));
        set.add(dist(p1, p3));

        return ! set.contains(0) && set.size() == 2;

    }

    private int dist(int[] a, int b[]){
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}