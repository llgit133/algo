package org.example.easy.FirstPage;

public class leetcode_21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 !=null && list2 != null){

            if( list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next =( list1 != null) ? list1 : list2;
        return head.next;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);


        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;

        m1.next = m2;
        m2.next = m3;
        ListNode node = mergeTwoLists(n1, m1);
        while (node != null){
            System.out.print(" "+node.val);
            node = node.next;
        }
    }
}


