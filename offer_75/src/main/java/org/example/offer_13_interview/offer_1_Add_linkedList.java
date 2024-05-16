package org.example.offer_13_interview;

public class offer_1_Add_linkedList {

    public static ListNode Add_linkedList(ListNode headA, ListNode HeadB){

        ListNode node1 = reverseList(headA);
        ListNode node2 = reverseList(HeadB);

        ListNode dummy_head = new ListNode(-1);
        dummy_head.next = node1;

        while (node2 != null){
            node1.val = node1.val + node2.val;
            node2 = node2.next;
            node1 = node1.next;
        }

        return reverseList(dummy_head.next);
    }

    public static ListNode addInList (ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {return null;}

        // 将两个链表进行反转
        ListNode l1 = reverseList(head1);
        ListNode l2 = reverseList(head2);

        ListNode res = new ListNode(0);
        ListNode tmp = res;
        int carry = 0; // 是否需要进位

        while (l1 != null || l2 != null) {
            int val = carry;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            carry = val / 10;
            tmp.next = new ListNode(val % 10);
            tmp = tmp.next;
        }

        if (carry != 0) {
            tmp.next = new ListNode(carry);// 如果 carry != 0，即需要进位，新增一个节点
        }

        // 把相加链表的值再反转
        return reverseList(res.next);
    }

    public static ListNode reverseList(ListNode head){

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);

        a1.next = a2;
        a1.next.next = a3;
        a1.next.next.next = a4;


        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        b1.next = b2;

//        ListNode node = Add_linkedList(a1, b1);

        ListNode node = addInList(a1, b1);
        // 1 2 6 8
        while (node != null){
            System.out.print(" "+node.val);
            node = node.next;
        }




    }
}



