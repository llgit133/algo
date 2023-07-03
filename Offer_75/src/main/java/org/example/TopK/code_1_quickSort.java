package org.example.TopK;

import java.util.Arrays;

public class code_1_quickSort{
    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0){return new int[0];}
        else if(arr.length <= k){return arr;}

        quickSelect(arr,0,arr.length - 1,k-1);

        return Arrays.copyOfRange(arr,0,k);
    }

    public static void quickSelect(int[] arr,int low,int high ,int k) {
        int m = partition(arr,low,high);
        if(k == m){return;}
        else if(k < m) {quickSelect(arr,low,m - 1,k);}
        else{quickSelect(arr,m+1,high,k);}
    }

    // 严蔚敏经典的快速排序  partition 函数
    public static int partition(int[] arr,int left, int right) {
        int pivot = arr[left];
        while(left < right) {
            while(left < right && arr[right] >= pivot)  right--;
            arr[left] = arr[right];
            while(left < right && arr[left] <= pivot)   left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {9, 7, 2, 4, 8, 1, 6, 3, 5};
        int k = 3;

        int[] topK = getLeastNumbers(nums, k);
        System.out.println("Top " + k + " elements: " + Arrays.toString(topK));
    }
}


