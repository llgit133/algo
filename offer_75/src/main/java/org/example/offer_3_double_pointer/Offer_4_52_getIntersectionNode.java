package org.example.offer_3_double_pointer;

import java.util.HashSet;
import java.util.Set;
//剑指 Offer 52. 两个链表的第一个公共节点
//输入两个链表，找出它们的第一个公共节点。
public class Offer_4_52_getIntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if(set.contains(headB)){return headB;} // 找到公共节点 set 比较的是 listNode 的hash code
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {

        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);

        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);

        a1.next = a2;
        a2.next = c1;

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        c1.next = c2;
        c2.next = c3;

        ListNode node = getIntersectionNode(a1, b1);
        System.out.println(node.val);
    }
}
