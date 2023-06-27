package org.example.think_6_stack_queue;


//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

//示例 1:
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]

//示例 2:
//输入: nums = [1], k = 1
//输出: [1]

//要统计元素出现频率
//对频率排序
//找出前K个高频元素

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//优先级队列
public class LC_7_347_topKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>(); // 记录元素出现次数
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 根据value排序，小根堆
        // 将 kv 转化成数组
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 遍历map
        for(Map.Entry<Integer, Integer> x : map.entrySet()) {
            int[] tmp = new int[2];
            tmp[0] = x.getKey();
            tmp[1] = x.getValue();

            // 进队
            queue.offer(tmp);

            // 只要前k个、大于k个时出堆
            if(queue.size() > k) {queue.poll();}
        }

        int[] res = new int[k];
        // 获取优先队列里的元素 key
        for(int i = 0; i < k; i ++) {res[i] = queue.poll()[0];}
        return res;
    }


    public static void main(String[] args) {

    }
}
