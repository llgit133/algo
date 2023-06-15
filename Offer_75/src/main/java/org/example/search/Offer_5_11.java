package org.example.search;

public class Offer_5_11 {


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
