package org.example.think_5_double_point;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


//输入：s = "the sky is blue"
//输出："blue is sky the"

//输入：s = "  hello world  "
//输出："world hello"
//解释：反转后的字符串中不能存在前导空格和尾随空格。
public class LC_4_151_reverseWords {

    public static String reverseWords(String s) {
        s = s.trim();
        s.split("\\s+",-1);
        List<String> list = Arrays.asList(s.split("\\s+", -1));
        Collections.reverse(list);
        return String.join(" ", list);
    }


}
