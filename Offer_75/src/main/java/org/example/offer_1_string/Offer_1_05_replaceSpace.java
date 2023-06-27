package org.example.offer_1_string;


//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//输入：s = "We are happy."
//输出："We%20are%20happy."

public class Offer_1_05_replaceSpace {

    public static String replaceSpace(String s) {

        //    StringBuilder sb = new StringBuilder();
        //     for(int i = 0;i<s.length();i++){

        //         if(s.charAt(i) == ' ') {
        //             sb.append("%20");
        //         }
        //         else{
        //             sb.append(s.charAt(i));
        //         }
        //     }
        //     return sb.toString();
        // }

        String[] arr = s.split("\\s", -1);
        //String.join 可以在字符数组的间隙添加
        return String.join("%20", arr);

    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}
