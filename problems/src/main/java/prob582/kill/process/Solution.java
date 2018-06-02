package prob582.kill.process;

import java.util.*;

/**
 * Created by yanya04 on 9/9/2017.
 * Modified by yanya04 on 5/29/2018.
 */
public class Solution {

    /*
        Solution, DFS
    */

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer, List<Integer>> childMap = new HashMap<>();
        for(int i = 0; i < ppid.size(); i ++)
        {
            childMap.putIfAbsent(ppid.get(i), new ArrayList<>());
            childMap.get(ppid.get(i)).add(pid.get(i));
        }

        Queue<Integer> killQueue = new LinkedList<>();
        killQueue.offer(kill);

        List<Integer> killList = new ArrayList<>();
        while(!killQueue.isEmpty())
        {
            int killItem = killQueue.poll();
            killList.add(killItem);
            if(childMap.containsKey(killItem)){
                killQueue.addAll(childMap.get(killItem));
            }
        }
        return killList;
    }
}