package org.example.offer_2_linkedlist;


//剑指 Offer 24. 反转链表
public class Offer_2_24_reverseList {

    // 原地逆置
    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre; // 指向
            pre = cur;     // 赋值  将前一个节点移动到当前节点:
            cur = nxt;     // 赋值  将当前节点移动到下一个节点:
        }
        return pre;
    }

    // 头插法新建一条链表
    public static ListNode reverseList1(ListNode head) {
        ListNode dummy_head = new ListNode(-1);
        ListNode cur = dummy_head.next;

        while (head != null){
            ListNode temp = new ListNode(head.val);
            dummy_head.next = temp;
            temp.next = cur;
            cur = dummy_head.next;
            head = head.next;
        }
        return dummy_head.next;
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

        ListNode node = reverseList1(node1);
        while (node != null){
            System.out.print(" "+node.val);
            ;node = node.next;
        }
    }
}
