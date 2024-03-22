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
    public ListNode oddEvenList(ListNode head) {
        /*
            시간복잡도 O(n), 공간복잡도 O(1)로 홀수번째 node를 뒤로 link
         */
        //1. 예외처리(head가 비어있거나 하나일 경우)
        if(head==null){
            return null;
        } else if(head.next==null){
            return head;
        }

        //2. 전체 size 계산
        int size=1;
        for(ListNode i=head; i.next!=null; i=i.next){
            size++;
        }

        ListNode head2=null, iter2=null, iter=head, prev=head;
        for(int i=0; i<size; i++){
            if(i==0){
                iter=iter.next;
            } else if(i==1){
                head2=new ListNode(iter.val);
                iter2=head2;
                iter=iter.next;
                prev.next=iter;
            } else if(i==size-1){//merge
                iter.next=head2;
            } else if(i%2==0){
                prev=iter;
                iter=iter.next;
            } else if(i%2==1){
                iter2.next=new ListNode(iter.val);
                iter2=iter.next;
                iter=iter.next;
                prev.next=iter;
            }//공통코드는 없다.
        }//endfor

        return head;
    }
}