package org.example.linklist;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
public class LeetCode_4_24 {

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

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n1.next.next = n3;
        n1.next.next.next = n4;

        ListNode node = swapPairs(n1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}
