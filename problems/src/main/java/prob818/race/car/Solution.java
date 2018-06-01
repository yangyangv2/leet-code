package prob818.race.car;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
/*
    Created by yanya04 on 6/1/2018
 */
public class Solution {
    /*
        Time Complexity:  O(target * log(target))
        Space Complexity: O(target * log(target))

        between [-target, target], there're 2 * target * log(target) status combination.
    */
    public int racecar(int target) {
        int[] status = new int[]{0, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(status);

        Set<String> visited = new HashSet<>();

        visited.add(0 + ":" + 1);

        int step = 0, size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            while(size -- > 0){
                status = queue.poll();
                // two options
                int pos = status[0], speed = status[1];
                if(pos == target) return step;

                // hit A
                int[] a = new int[]{ pos + speed, speed * 2 };
                // hit B
                int[] r = new int[]{ pos, speed > 0 ? -1 : 1 };

                String akey = a[0] + ":" + a[1];
                String rkey = r[0] + ":" + r[1];


                if(Math.abs(a[0] - target) < target && visited.add(akey)){
                    queue.offer(a);
                }

                if(visited.add(rkey)){
                    queue.offer(r);
                }
            }
            step ++;
        }
        return -1;
    }
}
