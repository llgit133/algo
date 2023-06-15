package org.example.dp;

public class Offer_10_46 {

    public static int translateNum(int num) {
        String s = String.valueOf(num); // 将数字转为字符串
        int n = s.length();
        int[] f = new int[n + 1];

        f[0] = 1;  //初始化
        for(int i = 1; i <= n; i++){
            f[i] = f[i - 1];  //单独翻译s[i]
            if(i > 1){
                int t = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
                if(t >= 10 && t <= 25) //组合的数字范围在10 ~ 25之间
                    f[i] += f[i - 2];  //将s[i] 和 s[i - 1]组合翻译
            }
        }
        return f[n];
    }


    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

}
