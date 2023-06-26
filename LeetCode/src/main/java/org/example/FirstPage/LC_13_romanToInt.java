package org.example.FirstPage;

import java.util.HashMap;
import java.util.Map;

public class LC_13_romanToInt {

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum = 0;

        // 把一个小值放在大值的左边，就是做减法，否则为加法。
        int preNum = map.get(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = map.get(s.charAt(i));

            if(preNum < num) {sum = sum - preNum;}
            else {sum = sum + preNum;}
            preNum = num;
        }
        sum = sum + preNum;
        return sum;
    }


    public static void main(String[] args) {

        System.out.println(romanToInt("LVIII"));
    }
}
