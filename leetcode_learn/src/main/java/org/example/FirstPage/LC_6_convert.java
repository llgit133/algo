package org.example.FirstPage;


//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
//
//比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
//
//P   A   H   N
//A P L S I I G
//Y   I   R


//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I

import java.util.ArrayList;
import java.util.List;

// 4+1+1+   4+1+1  +...
public class LC_6_convert {


    // 二维数组？？ 确定了行数
    // 然后按行遍历
    public static String convert(String s, int numRows) {

        return null;
    }



    // n行StringBuilder  进行处理数据
    public static String convert1(String s, int numRows) {
        if(numRows < 2) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;

        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }

        StringBuilder res = new StringBuilder();

        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }


    public static void main(String[] args) {

        System.out.println(convert1("PAYPALISHIRING", 4));

    }
}
