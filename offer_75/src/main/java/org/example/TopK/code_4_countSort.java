package org.example.TopK;

public class code_4_countSort {

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {return new int[0];}

        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num: arr) {
            counter[num]++;
        }

        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {

            while (counter[num]-- > 0 && idx < k) {res[idx++] = num;}
            if (idx == k) {break;}
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {9, 7, 2, 4, 8, 1, 6, 3, 5};
        int k = 3;
        int[] ints = getLeastNumbers(nums, k);

        for (int anInt : ints) {
            System.out.println(" "+anInt);
        }
    }
}
