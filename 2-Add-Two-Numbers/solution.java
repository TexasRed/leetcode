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
        while (p1 != null && p2 != null) {
            int sum = (p1.val + p2.val + carrier);
            int digit = sum % 10;
            carrier = sum / 10;
            tail.next = new ListNode(digit);
            tail = tail.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            int sum = (p1.val + carrier);
            int digit = sum % 10;
            carrier = sum / 10;
            tail.next = new ListNode(digit);
            tail = tail.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            int sum = (p2.val + carrier);
            int digit = sum % 10;
            carrier = sum / 10;
            tail.next = new ListNode(digit);
            tail = tail.next;
            p2 = p2.next;
        }
        if (carrier > 0) {
            tail.next = new ListNode(carrier);
            tail = tail.next;
        }
        return header.next;
    }
}