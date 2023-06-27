package org.example.offer_6_search;


//剑指 Offer 11. 旋转数组的最小数字
//给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
// 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。

//注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

public class Offer_5_11_minArray {


    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            //只要右边比中间大，那右边一定是有序数组
            if (numbers[mid] < numbers[high]) {high = mid;}
            else if (numbers[mid] > numbers[high]) {low = mid + 1;}
            else {high --;}     // numbers[mid] == numbers[high
        }
        return numbers[low];
    }

    public static void main(String[] args) {

        // 数组的特点是，前一段有序、后一段也有序
        int [] nums = new int[]{3,4,5,1,2};

        System.out.println(minArray(nums));

    }
}
