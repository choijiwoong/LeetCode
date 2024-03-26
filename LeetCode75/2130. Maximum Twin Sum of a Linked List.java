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
    public int pairSum(ListNode head) {
        int size=1;
        Stack<Integer> stack=new Stack<Integer>();
        ListNode iter=head;
        while(iter.next!=null){
            size++;
            stack.push(iter.val);
            iter=iter.next;
        }
        stack.push(iter.val);

        int max=0;
        iter=head;
        for(int i=0; i<size/2; i++){
            int val=iter.val+stack.pop();
            if(val>max)
                max=val;
            iter=iter.next;
        }

        return max;
    }
}