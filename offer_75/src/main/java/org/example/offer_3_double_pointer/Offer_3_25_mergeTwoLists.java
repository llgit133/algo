package org.example.offer_3_double_pointer;


//剑指 Offer 25. 合并两个排序的链表   输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
public class Offer_3_25_mergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;

        // 尾插法
        while (l1 != null && l2 != null){
            if( l1.val <= l2.val ){
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 有链表未空
        cur.next = (l1==null) ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        ListNode b4 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = null;

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = null;

        ListNode node = mergeTwoLists(a1, b1);

        while (node != null){
            System.out.print(" "+node.val);
            node = node.next;
        }
    }
}
