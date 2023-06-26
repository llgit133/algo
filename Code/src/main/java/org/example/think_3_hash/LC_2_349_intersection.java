package org.example.think_3_hash;

import java.util.*;

public class LC_2_349_intersection {


    // 交集一：
    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set.contains(i)) {
                resSet.add(i);
            }
        }
        return resSet.stream().mapToInt(x -> x).toArray();
    }


    // 交集二：
    // 4,9,5
    // 9,4,9,8,4
    // 9 4
    public  static List<Integer> intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                list.add(num);
                count--;
                if (count > 0) {map.put(num, count);}
                else {map.remove(num);}
            }
        }

        return list;
    }

    public static void main(String[] args) {

        int [] a = new int[]{4,9,5};
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
