package org.example.FirstPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
public class LC_4_findMedianSortedArrays {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();
        int length = nums1.length+nums2.length;

        for(int i = 0;i < nums1.length;i++){list.add(nums1[i]);}
        for(int j = 0;j < nums2.length;j++){list.add(nums2[j]);}

        Collections.sort(list);

        if(length % 2 == 0){
            return (list.get(length/2)+list.get((length-1)/2))/2.0;
        }
        return (list.get(length/2))/1.0;

    }

    public static void main(String[] args) {
        int [] sum1 = new int[]{1,2};
        int [] sum2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(sum1, sum2));
    }
}
