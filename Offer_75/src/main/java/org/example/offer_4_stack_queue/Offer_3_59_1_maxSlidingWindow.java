package org.example.offer_4_stack_queue;

import java.util.Deque;
import java.util.LinkedList;


//剑指 Offer 59 - I. 滑动窗口的最大值
//输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7


public class Offer_3_59_1_maxSlidingWindow {


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



    public static int[] maxSlidingWindow1(int[] nums, int k) {

        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        // 未形成窗口
        // k = 3 时 k= 0,k= 1,k= 2
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }


        // 得到前三个元素的最大值
        res[0] = deque.peekFirst();

        // 形成窗口后
        for (int i = k; i < nums.length; i++) {

            // 删除 deque 中对应的 nums[i-1]
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();

            // 保持 deque 递减
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);

            // 记录窗口最大值
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        for (int anInt : ints) {
            System.out.print("   "+anInt);
        }
    }
}
