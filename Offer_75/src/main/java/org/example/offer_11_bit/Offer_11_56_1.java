package org.example.offer_11_bit;

// 找两个奇数
public class Offer_11_56_1 {

    // 1,2,10,4,1,4,3,3
    // 1，1，3，3，4，4，2，10
    public static int[] singleNumbers(int[] nums) {

        //1、eor = 2 ^ 10
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }

        //2、找 10或者2
        int rightOne = eor & (~eor + 1);
        int eOhasOne = 0;
        for (int num : nums) {
            if ((num & rightOne) != 0) {
                eOhasOne ^= num;
            }
        }

        //3、定10、2
        return new int[]{eOhasOne, eOhasOne ^ eor };
    }

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,10,4,1,4,3,3};
        int [] ints = singleNumbers(nums);
        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }

    }
}
