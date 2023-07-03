package org.example.think_3_hash;

import java.util.*;

public class LC_2_349_intersection {


    // 349. 两个数组的交集一：
    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set.contains(i)) {resSet.add(i);}
        }
        // set 转为数组
        return resSet.stream().mapToInt(x -> x).toArray();
    }


    // 350. 两个数组的交集 II  不去重交集
    // 4,9,5,4
    // 9,4,9,8,4
    // 9 4

    //输入：nums1 = [1,2,2,1], nums2 = [2,2]
    //输出：[2,2]
    public  static List<Integer> intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        // 其实必会大于等于0
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            // 这是冗余判断啊
            if (count > 0) {
                res.add(num);
                count--;
                if (count > 0) {map.put(num, count);}  // map做减1更新
                else {map.remove(num);}   // count <= 0
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int [] a = new int[]{4,9,5,4};
        int [] b = new int[]{9,4,9,8,4};
//        int[] ints = intersection(a, b);
//        for (int anInt : ints) {
//            System.out.print(anInt);
//        }

        List<Integer> list = intersect(a, b);
        for (Integer integer : list) {
            System.out.print(" "+integer);
        }

    }
}
