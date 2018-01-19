package prob582.kill.process;

import java.util.*;

/**
 * Created by yanya04 on 9/9/2017.
 */
public class Solution {

    /*
        WordDictionary, DFS
    */

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

        Map<Integer, List<Integer>> childMap = new HashMap<>();
        for(int i = 0; i < ppid.size(); i ++)
        {
            childMap.putIfAbsent(ppid.get(i), new ArrayList<>());
            childMap.get(ppid.get(i)).add(pid.get(i));
        }

        Stack<Integer> killStack = new Stack<>();
        killStack.add(kill);

        List<Integer> killList = new ArrayList<>();
        while(!killStack.isEmpty())
        {
            int killItem = killStack.pop();
            killList.add(killItem);
            if(childMap.containsKey(killItem)){
                killStack.addAll(childMap.get(killItem));
            }
        }
        return killList;
    }
}
