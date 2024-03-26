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
        List<Integer> list=new ArrayList<>();
        ListNode iter=head;
        while(iter.next!=null){
            list.add(iter.val);
            iter=iter.next;
        }
        list.add(iter.val);

        int max=0;
        int size=list.size();
        int value;
        for(int i=0; i<size/2; i++){
            value=list.get(i)+list.get(size-1-i);
            if(value>max)
                max=value;
        }

        return max;
    }
}