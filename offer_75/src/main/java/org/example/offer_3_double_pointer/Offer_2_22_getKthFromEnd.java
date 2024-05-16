package org.example.offer_3_double_pointer;

// 剑指 Offer 22. 链表中倒数第k个节点
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//返回链表 4->5.
public class Offer_2_22_getKthFromEnd {
    public static ListNode getKthFromEnd(ListNode head, int k) {

        ListNode a = head;
        ListNode b = head;
        while (k > 0){
            b = b.next;
            k--;
        }

        while (b != null){
            a = a.next;
            b = b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode node = getKthFromEnd(node1,2);
        while (node != null){
            System.out.print(" "+node.val);
            node = node.next;
        }
    }
}
