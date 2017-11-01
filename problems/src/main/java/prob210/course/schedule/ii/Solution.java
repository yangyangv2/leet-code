package prob210.course.schedule.ii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        /*
            Solution

            prepare graph, indegree, process queue
            BFS, record process sequence
        */

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        Queue<Integer> processQueue = new ArrayDeque<>();
        // result
        int[] processOrder = new int[numCourses];
        int processCount = 0;

        for(int i = 0; i < numCourses; i ++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] prereq: prerequisites){
            // finish prereq[1] will enable prereq[0]
            graph.get(prereq[1]).add(prereq[0]);

            // prereq[0] has one more prerequisite
            inDegree[prereq[0]] ++;
        }

        // put courses with no prerequiste into process queue
        for(int i = 0; i < numCourses; i ++){
            if(inDegree[i] == 0){
                processQueue.offer(i);
            }
        }

        // start BFS
        while(!processQueue.isEmpty()){
            Integer course = processQueue.poll();
            processOrder[processCount] = course;
            processCount ++;
            for(Integer enabled: graph.get(course)){
                inDegree[enabled] --;
                if(inDegree[enabled] == 0){
                    processQueue.offer(enabled);
                }
            }
        }

        if(processCount == numCourses){
            return processOrder;
        } else {
            return new int[0];
        }
    }
}