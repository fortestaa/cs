package Chapter6_Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 38. Clone graph
 * https://leetcode.com/problems/clone-graph/
 * 
 * Question:
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class Clone_graph {

	/**
	 * Solution:
	 * There are two main ways to traverse a graph: breadth-first or depth-first. Let’s try the depth-first approach first, which is a recursion algorithm. Then we will look at the breadth-first approach, which is an iterative algorithm that uses a queue.
	 */
	
	/**
	 * O(n) runtime, O(n) space – Depth-first traversal:
	 * A graph is simply represented by a graph node that serves as its starting point.
	 * In fact, the starting point could be any other graph nodes and it does not affect the cloning algorithm.
	 * As each of its neighbors is a graph node too, we could recursively clone each of its neighbors and assign it to each neighbor of the cloned node.
	 * We can easily see that it is doing a depth-first traversal of each node.
	 * Note that the graph could contain cycles, for example a node could have a neighbor that points back to it.
	 * Therefore, we should use a map that records each node’s copy to avoid infinite recursion.
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph) {
		if (graph == null)	return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return DFS(graph, map);
	}
	
	private UndirectedGraphNode DFS(UndirectedGraphNode graph,
			Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (map.containsKey(graph)) {
			return map.get(graph);
		}
		UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
		map.put(graph, graphCopy);
		for (UndirectedGraphNode neighbor : graph.neighbors) {
			graphCopy.neighbors.add(DFS(neighbor, map));
		}
		return graphCopy;
	}
	
	/**
	 * O(n) runtime, O(n) space – Breadth-first traversal:
	 */
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode graph) {
		if (graph == null)	return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.add(graph);
		UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
		map.put(graph, graphCopy);
		while (!q.isEmpty()) {
			UndirectedGraphNode node = q.poll();
			for (UndirectedGraphNode neighbor : node.neighbors) {
				if (map.containsKey(neighbor)) {
					map.get(node).neighbors.add(map.get(neighbor));
				} else {
					UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
					map.get(node).neighbors.add(neighborCopy);
					map.put(neighbor, neighborCopy);
					q.add(neighbor);
				}
			}
		}
		return graphCopy;
	}
	
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		
		UndirectedGraphNode(int val) {
			label = val;
		}
	}
}