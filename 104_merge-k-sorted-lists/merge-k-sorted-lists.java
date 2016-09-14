/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-lists
@Language: Java
@Datetime: 16-06-16 06:41
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    //Merge two by two
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return dummy.next;
    }
    
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        while (lists.size() > 1) {
            List<ListNode> newLists = new ArrayList<>();
            for (int i = 0; i < lists.size() - 1; i += 2) {
                ListNode merged = merge(lists.get(i), lists.get(i + 1));
                newLists.add(merged);
            }
            if (lists.size() % 2 == 1) {
                newLists.add(lists.get(lists.size() - 1));
            }
            lists = newLists;
        }
        return lists.get(0);
    }
}
