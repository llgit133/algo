package org.example.think_1_array;


import java.util.ArrayList;

//示例 1:
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
public class LC_2_283_moveZeroes {


    // 思路: 一定要反过来想,不要只盯着0,可以设置一个指针,就是专业收集不是零的数
    // 收集一遍后,后面的一定是0,就再将空出来的位置设置为0,就解决问题了
    // 双指针收集一遍
    public static void moveZeroes(int[] nums) {

        int s=0;//定义收集不是0的数的指针
        //开始收集不是零的数
        for (int i = 0; i < nums.length ;i++) {
            if(nums[i] != 0){
                nums[s++] = nums[i];
            }
        }
        //收集完毕后,后面自然就都是0了
        for (int i = s; i < nums.length; i++) {nums[i]=0;}

        for (int num : nums) {System.out.print(" "+num);}
    }


    // 不够巧妙
    public static void moveZeroes1(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {if (nums[i] != 0) list.add(nums[i]);}
        for (int i = 0; i < nums.length; i++) {if (nums[i] == 0) list.add(nums[i]);}
        for (int i = 0; i < nums.length; i++) {nums[i] = list.get(i);}

        for (int num : nums) {System.out.print(" "+num);}
    }



    public static void main(String[] args) {

        int [] nums = new int[]{0,1,0,3,12};
        moveZeroes1(nums);
    }
}
