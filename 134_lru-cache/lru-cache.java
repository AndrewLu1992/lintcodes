/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/lru-cache
@Language: Java
@Datetime: 16-06-27 08:18
*/

public class Solution {
    private class Node {
        Node prev;
        Node next;
        int value;
        int key;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        Node curr = map.get(key);
        //Remove curr from LinkedList
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        // Insert curr into the tail
        curr.prev = tail.prev;
        tail.prev = curr;
        curr.prev.next = curr;
        curr.next = tail;
        return curr.value;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        //Atention !! If we found the node in LRU, then we need
        //to update doublelinkedlist as well!
        //Not map.get which will not update doublelinkedlist.
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() >= this.capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        //Insert the newNode into the tail.
        newNode.prev = tail.prev;
        tail.prev = newNode;
        newNode.prev.next = newNode;
        newNode.next = tail;
    }
}