package org.example.think_5_double_point;


//输入：s = "We are happy."
//输出："We%20are%20happy."
public class LC_3_offer_05_replaceSpace {

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

        String[] arr = s.split("\\s",-1);
        return String.join("%20",arr);
    }

    public static void main(String[] args) {

    }
}
