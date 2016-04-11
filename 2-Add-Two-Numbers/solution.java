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
        ListNode tail = header;
        ListNode p1 = l1, p2 = l2;
        int carrier = 0;
        while (p1 != null && p2 != null) {
            int digit = (p1.val + p2.val + carrier) % 10;
            carrier = (p1.val + p2.val + carrier) / 10;
            tail.next = new ListNode(digit);
            tail = tail.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        while (p1 != null) {
            if (carrier == 0) {
                tail.next = p1;
                break;
            } else {
                int digit = (p1.val + carrier) % 10;
                carrier = (p1.val + carrier) / 10;
                tail.next = new ListNode(digit);
                tail = tail.next;
                p1 = p1.next;
            }
        }
        
        while (p2 != null) {
            if (carrier == 0) {
                tail.next = p2;
                break;
            } else {
                int digit = (p2.val + carrier) % 10;
                carrier = (p2.val + carrier) / 10;
                tail.next = new ListNode(digit);
                tail = tail.next;
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