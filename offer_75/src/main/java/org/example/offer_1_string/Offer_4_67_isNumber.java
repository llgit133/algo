package org.example.offer_1_string;

import java.util.HashMap;
import java.util.Map;

//剑指 Offer 67. 把字符串转换成整数

//输入: "4193 with words"
//输出: 4193
//解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

//输入: "words and 987"
//输出: 0
//解释: 第一个非空字符是 'w', 但它不是数字或正、负号。因此无法执行有效的转换。

public class Offer_4_67_isNumber {

    enum State{
        start,
        signed,
        in_number,
        end
    }

    enum CharType{
        nullChar,
        sign,
        number,
        other
    }

    static final int INT_MIN = (int) (Math.pow(2, 31) * (-1));
    static final int INT_MAX = (int) (Math.pow(2, 31)) - 1;

    public static int isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();

        Map<CharType, State> StartMap = new HashMap<CharType, State>() {{
            put(CharType.nullChar, State.start);
            put(CharType.sign, State.signed);
            put(CharType.number, State.in_number);
        }};
        transfer.put(State.start, StartMap);

        Map<CharType, State> SignMap = new HashMap<CharType, State>() {{
            put(CharType.number, State.in_number);
        }};
        transfer.put(State.signed, SignMap);

        Map<CharType, State> in_numberMap = new HashMap<CharType, State>() {{
            put(CharType.number, State.in_number);
            put(CharType.nullChar, State.end);
            put(CharType.sign, State.end);
            put(CharType.other, State.end);
        }};
        transfer.put(State.in_number, in_numberMap);

        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.nullChar, State.end);
            put(CharType.sign, State.end);
            put(CharType.number, State.end);
            put(CharType.other, State.end);

        }};
        transfer.put(State.end, endMap);

        int length = s.length();
        State state = State.start;
        StringBuilder sb  = new StringBuilder();
        int flag = 0;  //flag定正负

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {return -1;}

            else {
                state = transfer.get(state).get(type);

                // 当前位是数字
                if(state == State.in_number ){sb.append(s.charAt(i));}

                // 当前位是符号 负号时flag = -1,
                if(state == State.signed ){flag = s.charAt(i) == '-' ? -1 : 1;}
            }
        }


        // TODO 待办1
        // 判断最后一个字符的状态、这样才符合数字的定义
        int res  = 0;
        if(state == State.in_number || state == State.end) {

            // 把收集到的字符转为数字“123” -> 123
            for (int i = 0; i < sb.length(); i++) {
                int temp = sb.charAt(i) - '0';
                res = res * 10 + temp;
            }

            // 最值判断
            if (res * flag < INT_MIN) return INT_MIN;
            else if (res * flag > INT_MAX) return INT_MAX;
            else return flag * res;
        }
        return -1;

    }

    public static CharType toCharType(char ch) {
        if (ch >= '0' && ch <= '9') return CharType.number;
        else if (ch == '+' || ch == '-') return CharType.sign;
        else if (ch == ' ') return CharType.nullChar;
        else return CharType.other;
    }

    public static void main(String[] args) {
        System.out.println(isNumber(" +98 7 65 432      "));
    }
}
