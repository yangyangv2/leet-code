package prob133.clone.graph;

import utils.graph.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 10/21/2017.
 * Modified by yanya04 on 5/2/2018.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node, new HashMap<Integer, UndirectedGraphNode>());
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map){
        if(node == null) return node;
        if(map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node.label, clone);
        for(UndirectedGraphNode neighbor: node.neighbors){
            clone.neighbors.add(clone(neighbor, map));
        }
        return clone;
    }
}
