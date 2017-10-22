package utils.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 10/21/2017.
 */
public class UndirectedGraphNode
{
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
