package org.example.FirstPage;


//给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。

//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
public class LC_2_addTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        int addOne = 0;
        while (l1 != null || l2!=null ||addOne!=0){

            // 三元表达式
            int val1 = (l1==null?0:l1.val);
            int val2 = (l2==null?0:l2.val);
            int sum = val1 + val2 + addOne;

            ListNode node = new ListNode(sum % 10);
            addOne = sum / 10;

            // 头插法 建立链表
//            ListNode next = head.next;
//            head.next = node;
//            node.next = next;

            // 尾插法
            head.next = node;
            head = head.next;


            // 继续
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }


    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        int addOne=0;

        ListNode dummy = new ListNode(0);// 头节点
        ListNode head = dummy;
        while(l1 != null || l2!=null ||addOne!=0){

            // 三元表达式
            int val1 = (l1==null?0:l1.val);
            int val2 = (l2==null?0:l2.val);
            int sum = val1 + val2 + addOne;

            head.next = new ListNode(sum % 10);  //取个位数
            head = head.next;
            addOne = sum /10;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {


        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);

        b1.next = b2;
        b2.next = b3;

        ListNode node = addTwoNumbers(a1, b1);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
