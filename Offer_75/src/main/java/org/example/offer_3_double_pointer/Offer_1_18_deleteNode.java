package org.example.offer_3_double_pointer;


// 剑指 Offer 18. 删除链表的节点
//输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

public class Offer_1_18_deleteNode {

    public static ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode pre = head;
        ListNode cur = head.next;

        // 找要删除节点的前一个节点
        while (cur !=null && cur.val != val){
            pre = pre.next;
            cur = cur.next;
        }

        if (cur!= null) pre.next = cur.next;
        return head;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = deleteNode(node1, 5);
        while (node != null){
            System.out.print(" "+node.val);
            node = node.next;
        }
    }
}
