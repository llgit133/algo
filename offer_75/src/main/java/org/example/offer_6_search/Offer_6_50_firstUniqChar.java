package org.example.offer_6_search;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer 50. 第一个只出现一次的字符

//输入：s = "abaccdeff"
//输出：'b'
public class Offer_6_50_firstUniqChar {

    public static char firstUniqChar(String s) {

        Map<Character, Boolean> map = new HashMap<>();

        // 字符首次进入为true  再次进入为false
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), !map.containsKey(s.charAt(i)));
        }

        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == true) return s.charAt(i);
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }
}
