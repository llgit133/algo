package org.example.offer_12_math;

import java.util.HashSet;

public class Offer_2_66 {

    public static int[] constructArr(int[] a) {
        int [] res = new int[a.length];

        HashSet<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i = 0; i < a.length; i++) {
            HashSet<Integer> temp = new HashSet<>();
            temp.add(a[i]);
            set.removeAll(temp);
            int sum = 1;
            for (Integer integer : set) {
                sum = sum * integer;
            }
            res[i] = sum;
            set.add(a[i]);
        }
        return res;
    }


    public static int[] constructArr2(int[] a) {
        int[] ans = new int[a.length];

        int p = 1;
        for (int i = 0; i < a.length; i++) {
            ans[i] = p;
            p *= a[i];
        }

        p = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            ans[i] *= p;
            p *= a[i];
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5};
        int[] ints = constructArr(nums);
        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }
    }
}
