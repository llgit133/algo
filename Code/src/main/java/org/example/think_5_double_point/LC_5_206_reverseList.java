package org.example.think_5_double_point;

import org.example.think_5_double_point.ListNode;

public class LC_5_206_reverseList {

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;// 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
