package prob785.is.graph.bipartite;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yanya04 on 6/12/2018.
 */
public class Solution {
    public boolean isBipartite(int[][] graph)
    {
        return bfs(graph);
    }

    private boolean bfs(int[][] graph)
    {
        if(graph == null || graph.length == 0)
            return true;

        int n = graph.length;
        int[] marks = new int[n];

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i ++){

            if(marks[i] != 0) continue;
            marks[i] = 1;
            queue.offer(i);
            while(! queue.isEmpty()){
                int cur = queue.poll();

                if(graph[cur] == null)
                    continue;

                for(int nb : graph[cur])
                {
                    if(marks[nb] != 0 && marks[nb] == marks[cur])
                        return false;

                    if(marks[nb] == 0){
                        marks[nb] = -marks[cur];
                        queue.offer(nb);
                    }
                }
            }
        }
        return true;

    }


    private boolean dfs(int[][] graph)
    {
        if(graph == null || graph.length == 0)
            return true;

        int n = graph.length;
        int[] marks = new int[n];

        for(int i = 0; i < n; i ++){

            if(marks[i] == 0 && !isValid(graph, marks, i, 1)){
                return false;
            }
        }
        return true;
    }


    private boolean isValid(int[][] graph, int[] marks, int index, int mark)
    {
        if(marks[index] != 0){
            return mark == marks[index];
        }

        marks[index] = mark;

        if(graph[index] == null || graph[index].length == 0)
            return true;

        for(int nb: graph[index]){
            if(! isValid(graph, marks, nb, -mark) ){
                return false;
            }
        }
        return true;
    }
}