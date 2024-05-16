package org.example.FirstPage;

import java.util.HashMap;
import java.util.Map;


//函数myAtoi(string s) 的算法如下：
//读入字符串并丢弃无用的前导空格
//检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
//读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
//将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
//如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
//返回整数作为最终结果。

public class LC_8_myAtoi {

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

        // 1.
        Map<CharType, State> StartMap = new HashMap<CharType, State>() {{
            put(CharType.nullChar, State.start);
            put(CharType.sign, State.signed);
            put(CharType.number, State.in_number);
        }};
        transfer.put(State.start, StartMap);

        // 2.
        Map<CharType, State> SignMap = new HashMap<CharType, State>() {{
            put(CharType.number, State.in_number);
        }};
        transfer.put(State.signed, SignMap);

        // 3.
        Map<CharType, State> in_numberMap = new HashMap<CharType, State>() {{
            put(CharType.number, State.in_number);
            put(CharType.nullChar, State.end);
            put(CharType.sign, State.end);
            put(CharType.other, State.end);
        }};
        transfer.put(State.in_number, in_numberMap);

        // 4.
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
        int flag = 0;

        for (int i = 0; i < length; i++) {
            CharType type = toCharType(s.charAt(i));
            if (!transfer.get(state).containsKey(type)) {
                return -1;
            } else {
                state = transfer.get(state).get(type);
                if(state == State.in_number ){
                    sb.append(s.charAt(i));
                }
                if(state == State.signed ){
                    flag = s.charAt(i) == '-' ? -1 : 1;
                }
            }
        }

        if(state == State.in_number || state == State.end) {
            int res = 0;

            for (int i = 0; i < sb.length(); i++) {
                int temp = sb.charAt(i) - '0';
                res = res * 10 + temp;
            }

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
        System.out.println(isNumber("42"));
    }
}

