/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/six-degrees
@Language: Java
@Datetime: 16-07-03 01:40
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (graph == null || graph.size() == 0 || s == t) {
            return 0;
        }
        HashMap<UndirectedGraphNode, Integer> visited = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(s);
        visited.put(s, 0);
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (visited.containsKey(neighbor)) {
                    continue;
                }
                //Attension you need to comapre it with the node itself
                //but not label
                if (neighbor == t) {
                    return visited.get(node) + 1;
                }
                queue.offer(neighbor);
                visited.put(neighbor, visited.get(node) + 1);
            }
        }
        return -1;
    }
}