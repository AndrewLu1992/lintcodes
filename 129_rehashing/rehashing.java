/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/rehashing
@Language: Java
@Datetime: 16-06-26 05:23
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }
        int newCap = hashTable.length * 2;
        ListNode[] newTable = new ListNode[newCap]; 
        for (int i = 0; i < hashTable.length; i++) {
            while (hashTable[i] != null) {
                int index = (hashTable[i].val % newCap + newCap) % newCap;
                if (newTable[index] == null) {
                    newTable[index] = new ListNode(hashTable[i].val);
                } else {
                    ListNode dummy = newTable[index];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return newTable;
    }
};
