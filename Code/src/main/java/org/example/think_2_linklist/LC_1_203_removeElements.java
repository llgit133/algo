package org.example.think_2_linklist;


//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
public class LC_1_203_removeElements {

    public static ListNode removeElements(ListNode head, int val) {

        while(head!=null && head.val==val){head = head.next;}

        ListNode dummy_head = new ListNode(-1);
        dummy_head.next = head;

        while (head != null){
            if(head.next.val == val){head.next = head.next.next;}
            head = head.next;
        }
        return dummy_head.next;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);
        n1.next = n2;
        n1.next.next = n3;
        n1.next.next.next = n4;
        n1.next.next.next.next = n5;
        n1.next.next.next.next.next = n6;
        n1.next.next.next.next.next.next= n7;

        ListNode node = removeElements(n1, 6);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
