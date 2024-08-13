package com.interview;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * */
public class lc_02_majorityElement {



    // 1.map的方式
    // map 计数 key为元素，value 为元素出现的次数
    public static int Solution(int [] a){

        Map<Integer, Integer> map = new HashMap<>();


        //1.计数
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])){
                map.put(a[i], map.get(a[i]) + 1);
            }else  map.put(a[i],1 );
        }

        //2.遍历查找
        for (Integer i : map.keySet()) {
            if(map.get(i) > a.length / 2){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int [] a = {2,2,1,1,1,2,2};
        System.out.println(Solution(a));
    }
}
