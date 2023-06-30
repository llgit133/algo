package org.example.think_8_backtrack_hard;

import java.util.ArrayList;
import java.util.List;




//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
public class LC_3_17_letterCombinations {


    //设置全局列表存储最后的结果
    static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {return result;}
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTracking(digits, numString, 0);
        return result;
    }

    static StringBuilder temp = new StringBuilder();
    public static void backTracking(String digits, String[] numString, int num) {

        //遍历全部一次记录一次得到的字符串
        if (num == digits.length()) {
            result.add(temp.toString());
            return;
        }

        String str = numString[digits.charAt(num) - '0'];//"2" -> "abc"
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, numString, num + 1);
            temp.deleteCharAt(temp.length() - 1); //剔除末尾的继续尝试
        }
    }


    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        for (String s : list) {
            System.out.print(" "+s);
        }
    }
}
