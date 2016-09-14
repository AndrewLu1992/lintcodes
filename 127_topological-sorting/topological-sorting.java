/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 16-07-01 01:47
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    private class Element {
        DirectedGraphNode node;
        int neighborIndex;
        public Element(DirectedGraphNode node, int index) {
            this.node = node;
            neighborIndex = index;
        }
    }
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if (graph == null || graph.size() == 0) {
            return graph;
        }
        Stack<Element> stack = new Stack<>();
        HashSet<DirectedGraphNode> set = new HashSet<>();
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                set.add(neighbor);
            }
        }
        //Find nodes with in-degree 0.
        for (DirectedGraphNode node : graph) {
            if (!set.contains(node)) {
                stack.push(new Element(node, -1));
            }
        }
        set = new HashSet<DirectedGraphNode>();
        //DFS
        while (!stack.empty()) {
            Element top = stack.peek();
            top.neighborIndex++;
            //if there is no more neighbors to be searched.
            if (top.neighborIndex == top.node.neighbors.size()) {
                result.add(top.node);
                stack.pop();
                continue;
            }
            DirectedGraphNode next =
                top.node.neighbors.get(top.neighborIndex);
            //check if the neighbor is added
            if (set.contains(next)) {
                continue;
            }
            stack.push(new Element(next, -1));
            set.add(next);
        }
        Collections.reverse(result);
        return result;
    }
}