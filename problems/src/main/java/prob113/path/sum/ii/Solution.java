package prob113.path.sum.ii;

import utils.graph.UndirectedGraphNode;

import java.util.*;

/**
 * Created by yanya04 on 10/1/2017.
 * Modified by yanya04 on 6/10/2018.
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return bfs(node);
    }

    private UndirectedGraphNode bfs(UndirectedGraphNode node) {
        if(node == null) return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        UndirectedGraphNode root = node;
        queue.offer(root);
        map.put(root, new UndirectedGraphNode(root.label));

        while(!queue.isEmpty()){
            node = queue.poll();
            for(UndirectedGraphNode neighbor: node.neighbors){
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(node).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(root);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }

    private UndirectedGraphNode dfs(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {

        if(node == null) return null;

        if(map.containsKey(node)) return map.get(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        for(UndirectedGraphNode neighbor: node.neighbors){
            map.put(neighbor, dfs(neighbor, map));
            copy.neighbors.add(map.get(neighbor));
        }
        return copy;
    }
}
