package org.example.think_6_stack_queue;


//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7

import java.util.Deque;
import java.util.LinkedList;

public class LC_6_239_maxSlidingWindow {


    // 计算所有、前k-1个不取
    // 1、3、      3、3、5、5、6、7
    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length];

        deque.addLast(nums[0]);
        res[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            //if (deque.peekFirst() == nums[i]) {deque.removeFirst();}

            // 保持 deque 递减  5、3   -> 6
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);

            // 记录窗口最大值
            res[i] = deque.peekFirst();
        }
        return res;
    }


    public static void main(String[] args) {

    }

}
