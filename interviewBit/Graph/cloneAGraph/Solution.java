import java.util.*;

//Definition for undirected graph.
class UndirectedGraphNode {
   int label;
   List<UndirectedGraphNode> neighbors;
   UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 }

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
    {
        HashMap<Integer,UndirectedGraphNode> visited = new HashMap<>();
        UndirectedGraphNode toReturn = explore(node,visited);
        return toReturn;
    }

    public UndirectedGraphNode explore(UndirectedGraphNode oldNode,HashMap<Integer,UndirectedGraphNode> visited)
    {
        if(visited.containsKey(oldNode.label))
            return visited.get(oldNode.label);

        UndirectedGraphNode newNode = new UndirectedGraphNode(oldNode.label);
        visited.put(oldNode.label,newNode);
        for(UndirectedGraphNode adjacent : oldNode.neighbors)
        {
           newNode.neighbors.add(explore(adjacent,visited)) ;
        }

        return newNode;
    }

}
