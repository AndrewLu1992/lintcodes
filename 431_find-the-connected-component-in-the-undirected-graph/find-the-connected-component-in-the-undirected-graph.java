/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/find-the-connected-component-in-the-undirected-graph
@Language: Java
@Datetime: 16-07-04 15:24
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    private HashSet<UndirectedGraphNode> bfs(UndirectedGraphNode node) {
        HashSet<UndirectedGraphNode> component = new HashSet<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        component.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode crt = q.poll();
            for (UndirectedGraphNode next : crt.neighbors) {
                if (!component.contains(next)) {
                    q.offer(next);
                    component.add(next);
                }
            }
        }
        return component;
    }
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return result;
        }
        HashSet<UndirectedGraphNode> totalNodes = new HashSet<>(nodes);
        //Union Find Algorithm here
        while (!totalNodes.isEmpty()) {
            //!!! Attention. Cannot define an iterator outside loop
            /**Because we modify the HashSet and it will raise error
            if we use iterator of hashSet before modification.*/
            Iterator<UndirectedGraphNode> itr = totalNodes.iterator();
            UndirectedGraphNode node = itr.next();
            HashSet<UndirectedGraphNode> component = bfs(node);
            List<Integer> solution = new ArrayList<>();
            for (UndirectedGraphNode n : component) {
                solution.add(n.label);
                totalNodes.remove(n);
            }
            //The result needed to be sorted.
            Collections.sort(solution);
            result.add(solution);
        }
        return result;
    }
}