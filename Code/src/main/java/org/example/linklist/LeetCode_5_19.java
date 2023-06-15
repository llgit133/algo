package org.example.linklist;


//删除链表的倒数第N个节点
public class LeetCode_5_19 {


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode A = head;
        while ( n >= 0 ){
            A = A.next;
            n--;
        }

        ListNode B = head;
        while (A != null){
            A = A.next;
            B = B.next;
        }

        // 删除
        B.next = B.next.next;

        return head;
    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n1.next.next = n3;
        n1.next.next.next = n4;
        n1.next.next.next.next = n5;

        ListNode node = removeNthFromEnd(n1,2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
