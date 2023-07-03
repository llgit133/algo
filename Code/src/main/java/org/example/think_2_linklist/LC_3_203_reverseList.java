package org.example.think_2_linklist;


//示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL

import java.util.Stack;

//1、双指针法
//2、递归法
//3、使用虚拟头结点解决链表翻转
//4、使用栈解决反转链表的问题
public class LC_3_203_reverseList {

    //1、双指针法  原地反转链表
    public static ListNode reverseList1(ListNode head) {

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


    //3、使用虚拟头结点解决链表翻转
    // 迭代方法：增加虚头结点，使用头插法实现链表翻转
    public static ListNode reverseList3(ListNode head) {

        ListNode dumpyHead = new ListNode(-1);
        dumpyHead.next = null;

        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            // 头插法,可以做到链表反转
            cur.next = dumpyHead.next;
            dumpyHead.next = cur;
            cur = temp;
        }
        return dumpyHead.next;
    }


    //4、
    public ListNode reverseList4(ListNode head) {
        // 如果链表为空，则返回空
        if (head == null) return null;

        // 如果链表中只有只有一个元素，则直接返回
        if (head.next == null) return head;

        // 创建栈 每一个结点都入栈
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        // 创建一个虚拟头结点
        ListNode pHead = new ListNode(0);
        cur = pHead;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            cur.next = node;
            cur = cur.next;
        }
        // 最后一个元素的next要赋值为空
        cur.next = null;
        return pHead.next;
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

        ListNode node = reverseList1(n1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}
