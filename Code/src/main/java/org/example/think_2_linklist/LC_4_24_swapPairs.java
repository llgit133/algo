package org.example.think_2_linklist;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
public class LC_4_24_swapPairs {

    public static ListNode swapPairs(ListNode head) {

        ListNode A = head;
        ListNode B = A.next;

        while (A != null && B != null ){
            swap(A.val, B.val);

            A = B.next;
            B = A.next;
        }

        return head;
    }

    public static void swap(int A , int B){
        int temp = A;
        A = B;
        B = temp;
    }



    public static ListNode swapPairs1(ListNode head) {
        ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
        dumyhead.next = head; // 将虚拟头结点指向head，这样方面后面做删除操作
        ListNode cur = dumyhead;

        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点

        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;

            cur.next = secondnode;       // 步骤一
            secondnode.next = firstnode; // 步骤二
            firstnode.next = temp;      // 步骤三
            cur = firstnode; // cur移动，准备下一轮交换
        }
        return dumyhead.next;
    }
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n1.next.next = n3;
        n1.next.next.next = n4;

        ListNode node = swapPairs1(n1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}
