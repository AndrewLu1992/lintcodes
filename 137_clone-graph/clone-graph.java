/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 16-06-30 22:50
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    //Breath First Search
    private ArrayList<UndirectedGraphNode> bfs(UndirectedGraphNode node) {
        //Only difference: Use queue for bfs.
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode n : head.neighbors) {
                if (!set.contains(n)) {
                    queue.offer(n);
                    set.add(n);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
    
    //Depth First Search
    private class Element {
        UndirectedGraphNode node;
        int neighborIndex;
        public Element(UndirectedGraphNode n, int index) {
            node = n;
            neighborIndex = index;
        }
    }
    private ArrayList<UndirectedGraphNode> dfs(UndirectedGraphNode node) {
        //Only difference: Use Stack for dfs.
        Stack<Element> stack = new Stack<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        stack.push(new Element(node, -1));
        set.add(node);
        while (!stack.empty()) {
            Element n = stack.peek();
            n.neighborIndex++;
            //There is no more neighbors needed to be traversed
            if (n.neighborIndex == n.node.neighbors.size()) {
                stack.pop();
                continue;
            }
            UndirectedGraphNode neighbor =
                n.node.neighbors.get(n.neighborIndex);
            //Check if a node is visited before.
            if (set.contains(neighbor)) {
                continue;
            }
            stack.push(new Element(neighbor, -1));
            set.add(neighbor);
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }
        ArrayList<UndirectedGraphNode> nodes = dfs(node);
        //Need a map to copy the whole graph.
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for(UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }
        //Here is how to copy the topology of original graph.
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for(UndirectedGraphNode neighbor : n.neighbors) {
                newNode.neighbors.add(mapping.get(neighbor));
            }
        }
        return mapping.get(node);
    }
}