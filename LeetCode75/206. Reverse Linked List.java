/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode iter=head.next, prev=head, next_iter=head.next.next, next_prev=iter.next;
        prev.next=null;
        while(iter!=null){
            next_iter=iter.next;
            next_prev=iter;

            iter.next=prev;
            
            prev=next_prev;
            iter=next_iter;
        }

        return prev;
    }
}