/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Java
@Datetime: 16-06-16 10:41
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    private void copyRandom(RandomListNode head) {
        RandomListNode p = head.next;
        while (p != null) {
            if (p.random != null) {
                p.random = p.random.next;
            }
            if (p.next == null) {
                p = null;
            } else {
                p = p.next.next;
            }
        }
    }
    //!!! know how to split interval linkedList
    private RandomListNode split(RandomListNode head) {
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head = temp.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return split(head);
    }
}