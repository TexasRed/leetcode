/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
      
        // search for successor
        TreeLinkNode successor = root.next;
        while (successor != null) {
            if (successor.left != null) {
                successor = successor.left;
                break;
            } else if (successor.right != null){
                successor = successor.right;
                break;
            } else {
                successor = successor.next;
            }
        }
        if (root.right != null) {
            root.right.next = successor;
        }
        if (root.left != null) {
            root.left.next = root.right == null ? successor : root.right;
        }
        connect(root.right);
        connect(root.left);
    }
}