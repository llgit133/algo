package org.example.think_2_linklist;


//示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
//双指针法
public class LC_3_203_reverseList {

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

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n1.next.next = n3;
        n1.next.next.next = n4;
        n1.next.next.next.next = n5;

        ListNode node = reverseList(n1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}
