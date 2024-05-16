package org.example.think_2_linklist;


//142. 环形链表 II
//给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
public class LC_7_144_detectCycle {
    public static ListNode detectCycle(ListNode head) {

        ListNode slow = head;  // 走1步
        ListNode fast = head;  // 走2步

        // 找到相遇位置
        // 因为快指针是两步两步去跳、fast  fast.next
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // 有环
            if (slow == fast) {

                // 两个指针，从头结点和相遇结点
                // 各走一步，直到相遇，相遇点即为环入口

                ListNode index1 = fast;
                ListNode index2 = head;

                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                // 直到相遇、即为环的入口
                return index1;
            }
        }

        return null;
    }
    public static void main(String[] args) {

        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n1.next.next = n3;
        n1.next.next.next = n4;
        n4.next = n2;

        ListNode node = detectCycle(n1);
        System.out.println(node.val);

    }
}
