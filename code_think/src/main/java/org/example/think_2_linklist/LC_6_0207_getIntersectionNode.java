package org.example.think_2_linklist;


//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//输出：Intersected at '8'
//解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
//从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
//在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。


import java.util.HashSet;

public class LC_6_0207_getIntersectionNode {


    // 链表相交、hash即可
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if (set.contains(headB)) break;
            headB = headB.next;
        }

        return headB;
    }


    public static void main(String[] args) {

        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);

        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(5);
        ListNode c3 = new ListNode(4);

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);

        a1.next = a2;
        a1.next.next = c1;

        b1.next = b2;
        b1.next.next = b3;
        b1.next.next.next = c1;

        c1.next = c2;
        c1.next.next = c3;

        ListNode node = getIntersectionNode(a1, b1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}
