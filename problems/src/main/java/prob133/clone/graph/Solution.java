package prob133.clone.graph;

import utils.graph.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 10/21/2017.
 * Modified by yanya04 on 5/2/2018.
 * Modified by yanya04 on 5/18/2018.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return clone(node, map);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map){
        if(node == null) return null;
        if(map.containsKey(node.label))
            return map.get(node.label);

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for(UndirectedGraphNode neighbor: node.neighbors){
            clone.neighbors.add(clone(neighbor, map));
        }
        return clone;
    }
}