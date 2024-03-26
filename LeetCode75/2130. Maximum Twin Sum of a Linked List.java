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
        ListNode iter;
        for(iter=head; iter.next!=null; iter=iter.next)
            size++;

        int[] array=new int[size];
        int i=0;
        for(iter=head; iter.next!=null; iter=iter.next, i++)
            array[i]=iter.val;
        array[i]=iter.val;

        int val, max=0;
        for(i=0; i<size; i++){
            val=array[i]+array[size-1-i];
            if(val>max)
                max=val;
        }

        return max;
    }
}