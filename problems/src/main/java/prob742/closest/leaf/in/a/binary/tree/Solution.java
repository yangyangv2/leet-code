package prob742.closest.leaf.in.a.binary.tree;

import utils.tree.TreeNode;

import java.util.*;

/**
 * Created by yanya04 on 1/21/2018.
 */
public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*

        1. build a graph
        2. find the starting point
        3. BFS



    */

    private GraphNode startNode;

    public int findClosestLeaf(TreeNode root, int k) {

        if(root == null) return 0;
        if(root.left == null && root.right == null && root.val == k) return 1;


        startNode = null;
        buildGraph(root, null, k);
        return bfs(startNode);
    }

    private int bfs(GraphNode start){

        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(start);

        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()){
            List<GraphNode> nodes = new LinkedList<>();
            while(!queue.isEmpty()){
                nodes.add(queue.poll());
            }
            for(GraphNode node : nodes){
                if(node.isLeaf())
                    return node.val;
                visited.add(node.val);
                for(GraphNode edge: node.edges){
                    if(visited.contains(edge.val))
                        continue;

                    queue.offer(edge);
                }
            }

        }

        return -1;
    }



    private void buildGraph(TreeNode node, GraphNode parent, int k){
        if(node == null) return;

        GraphNode graphNode = new GraphNode(node.val, node.left == null && node.right == null);

        if(node.val == k)
            startNode = graphNode;

        if(parent != null){
            parent.addEdge(graphNode);
            graphNode.addEdge(parent);
        }

        buildGraph(node.left, graphNode, k);
        buildGraph(node.right, graphNode, k);

    }


    private static class GraphNode{
        int val;
        List<GraphNode> edges;
        boolean leaf;

        GraphNode(int val, boolean leaf){
            this.val = val;
            this.leaf = leaf;
            edges = new ArrayList<>();
        }

        void addEdge(GraphNode node){
            edges.add(node);
        }

        boolean isLeaf(){
            return leaf;
        }
    }




}
