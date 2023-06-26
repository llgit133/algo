package org.example.FirstPage;


//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.

// 通常情况下，罗马数字中小的数字在大的数字的右边。
// 但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
// 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：

public class LC_12_intToRoman {

    public static String intToRoman(int num) {
        int[] values =     {1000, 900, 500,  400, 100,  90,   50,   40,   10,  9,   5,   4,     1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < values.length; ++i) {
            int val = values[i];
            String sym = symbols[i];

            while (num >= val) {
                res.append(sym);
                num = num -  val;
            }
            if (num == 0) {break;}
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}
