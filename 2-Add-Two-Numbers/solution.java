/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode header = new ListNode(-1);
        ListNode p1 = l1, p2 = l2, tail = header;
        int carrier = 0;
        while (p1 != null || p2 != null) {
            int v1 = (p1 != null) ? p1.val : 0;
            int v2 = (p2 != null) ? p2.val : 0;
            int sum = (v1 + v2 + carrier);
            int digit = sum % 10;
            carrier = sum / 10;
            tail.next = new ListNode(digit);
            tail = tail.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carrier > 0) {
            tail.next = new ListNode(carrier);
            tail = tail.next;
        }
        return header.next;
    }
}