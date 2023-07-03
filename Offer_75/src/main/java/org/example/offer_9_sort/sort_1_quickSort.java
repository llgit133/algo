package org.example.offer_9_sort;

import java.util.Arrays;

public class sort_1_quickSort {

    public static void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(nums, left, right); // 获取枢轴元素的位置
            quickSort(nums, left, pivotIndex - 1); // 对枢轴元素左侧的子数组进行排序
            quickSort(nums, pivotIndex + 1, right); // 对枢轴元素右侧的子数组进行排序
        }
    }

    //严版教材中的划分算法（一趟排序过程）
    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];       //将表中第一个元素设为枢纽值，对表进行划分

        //循环跳出条件
        while (low < high) {

            //将比枢纽值小的元素移动到右端
            while (low < high && array[high] >= pivot) {high--;}
            array[low] = array[high];

            //将比枢纽值大的元素移动到左端
            while (low < high && array[low] <= pivot) {low++;}
            array[high] = array[low];
        }
        array[low] = pivot;    //将枢纽元素放回最终位置
        return low;            //返回存放枢纽的最终位置
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {9, 7, 2, 4, 8, 1, 6, 3, 5};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
