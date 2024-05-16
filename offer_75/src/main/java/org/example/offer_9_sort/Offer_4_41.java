package org.example.offer_9_sort;

import java.util.PriorityQueue;
import java.util.Queue;


//剑指 Offer 41. 数据流中的中位数

//[2,3,4] 的中位数是 3
//[2,3] 的中位数是 (2 + 3) / 2 = 2.5

//偶数个  size  n/2、n/2
//奇数个  size  n/2  +1 、 n/2
public class Offer_4_41 {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(5);
        System.out.println(finder.findMedian());

        finder.addNum(2);
        System.out.println(finder.findMedian());

        finder.addNum(4);
        System.out.println(finder.findMedian());

        finder.addNum(3);
        System.out.println(finder.findMedian());

        finder.addNum(1);
        System.out.println(finder.findMedian());

        finder.addNum(6);
        System.out.println(finder.findMedian());

    }
}


class MedianFinder {

    Queue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {

        // 向堆中加入元素

        // 长度为奇数时先放入小顶堆,排序后在插入到大顶堆
        if(A.size() != B.size()) {
            A.add(num);     //先放入小顶堆
            B.add(A.poll());//排序后在插入到大顶堆

        }

        // 长度为偶数时先放入大顶堆,重新排序后在插入到小顶堆
        else {
            B.add(num);         // 先放入大顶堆
            A.add(B.poll());   //重新排序后在插入到小顶堆
        }
    }


    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}