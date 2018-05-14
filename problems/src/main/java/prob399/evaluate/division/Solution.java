package prob399.evaluate.division;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yanya04 on 5/13/2018.
 */
public class Solution {

    /*
        a --2.0--> b
        b --0.5--> a

        b --3.0--> c
        c --0.3--> b

        a / c, b / a?
    */

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int len = values.length;
        String a = null, b = null;
        for(int i = 0; i < len; i ++){
            a = equations[i][0]; b = equations[i][1];
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1 / values[i]);
        }

        len = queries.length;
        double[] res = new double[len];

        for(int i = 0; i < len; i ++){
            a = queries[i][0]; b = queries[i][1];
            res[i] = dfs(graph, a, b, new HashSet<String>(), 1);
        }

        return res;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String a, String b, Set<String> visited, double value){
        if(!graph.containsKey(a) || !visited.add(a)) return -1;
        if(a.equals(b)) return value;
        double res = -1;
        for(Map.Entry<String, Double> entry: graph.get(a).entrySet()){
            res = dfs(graph, entry.getKey(), b, visited, value * entry.getValue());
            if(res != -1) return res;
        }
        return res;
    }

}