package org.example.offer_10_dp;



//剑指 Offer 46. 把数字翻译成字符串

//输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//这就是一个经典爬楼梯问题，给的num就是爬num.length级台阶，一次可以爬一级或者爬两级，只是这次爬两级需要做一个值小于26的判断。

public class Offer_6_46_translateNum {


    // 动态规划5部曲
    //1、dp[i] 不同的翻译
    //2、组合翻译、单独翻译   dp[i] = dp[i - 1] + dp[i - 2]、dp[i] = dp[i - 1]
    //3、初始化 dp[0] = 1、dp[1] = 1;
    //4、dp[i]依赖于dp[i - 1]的状态，需要从前向后遍历
    //5、举例推导dp数组
    public static int translateNum(int num) {

        String s = String.valueOf(num);   //"12258"

        //推导状态转移方程时，一般都是默认数组下标从1开始
        int[] dp = new int[s.length()+1];
        dp[0] = 1; //f[0] = 1，翻译前0个数的方法数为1。
        dp[1] = 1;


        //0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
        for(int i = 2; i <= s.length(); i ++){
            String temp = s.substring(i-2, i);  // 前包后不包

            // 组合的数字范围在10 ~ 25之间
            // 将s[i] 和 s[i - 1]组合翻译
            if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i-1] + dp[i-2];
            }

            //单独翻译s[i]
            else {dp[i] = dp[i-1];}
        }

        // 1、1、2、3、5、5
        return dp[s.length()];
    }


    public static void main(String[] args) {

        System.out.println(translateNum(12258));
    }
}
