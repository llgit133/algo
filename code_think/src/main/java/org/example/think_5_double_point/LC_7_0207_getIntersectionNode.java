package org.example.think_5_double_point;

import java.util.HashSet;


//面试题 02.07. 链表相交

//输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
//输出：Intersected at '8'

public class LC_7_0207_getIntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if (set.contains(headB)) break;
            headB = headB.next;
        }

        return headB;
    }

    public static void main(String[] args) {

    }
}
