package org.example.think_2_linklist;


//删除链表的倒数第N个节点
public class LC_5_19_removeNthFromEnd {


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode A = head;
        while ( n >= 0 ){
            A = A.next;
            n--;
        }

        ListNode B = head;
        while (A != null){
            A = A.next;
            B = B.next;
        }

        // 删除
        B.next = B.next.next;

        return head;
    }


    public  static ListNode removeNthFromEnd1(ListNode head, int n){
        ListNode dummy_head = new ListNode(0);
        dummy_head.next = head;

        ListNode fastIndex = dummy_head;
        ListNode slowIndex = dummy_head;

        //只要快慢指针相差 n 个结点即可
        for (int i = 0; i < n  ; i++){
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        //此时 slowIndex 的位置就是待删除元素的前一个位置。
        //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        slowIndex.next = slowIndex.next.next;
        return dummy_head.next;
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

        ListNode node = removeNthFromEnd1(n1,2);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
