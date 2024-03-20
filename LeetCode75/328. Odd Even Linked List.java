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
        if(head==null){
            return null;
        } else if(head.next==null){
            return head;
        }

        ListNode tail;
        int size=2;
        for(tail=head.next; tail.next!=null; tail=tail.next){size++;}
        System.out.println("size: "+size);

        ListNode tmp;
        while(head.val%2==0){//첫원소는 무조건 홀수
            tmp=head.next;
            head.next=null;
            tail.next=head;
            tail=tail.next;
            head=tmp;
        }

        int i=0;
        tmp=null;
        for(ListNode prev=head, node=head.next; node!=null&&i<size; i++){
            System.out.printf("prev: %d, node: %d, node.next: %d\n", prev.val, node.val, node.next.val);
            if(node.val%2==0){
                System.out.printf("Target detected. node: %d\n", node.val);
                prev.next=node.next;
                tail.next=node;
                tail=tail.next;//tail=node
                tail.next=null;
                node=prev.next;//node가 null로 변경
            } else{
                prev=node;
                node=node.next;
            }
            i++;
        }

        return head;
    }
}