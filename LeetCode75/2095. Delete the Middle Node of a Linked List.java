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
    public ListNode deleteMiddle(ListNode head) {
        int size=1;
        for(ListNode i=head; i.next!=null; i=i.next){
            size++;
        }

        int index=0, middle_index=size/2;//4면 2가되고 3이면 1이 되고.
        System.out.println(middle_index);
        for(ListNode i=head; i.next!=null; i=i.next, index++){
            if(index==middle_index-1){
                if(i.next.next!=null)
                    i.next=i.next.next;
                else
                    i.next=null;
                break;
            }
            index++;
        }

        return head;
    }
}