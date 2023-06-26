package org.example.offer_12_math;


//剑指 Offer 43. 1～n 整数中 1 出现的次数

//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
public class Offer_7_43 {

    public static int countDigitOne(int n) {
        //高位
        int high = n;
        //低位
        int low = 0;

        //当前位
        int cur = 0;
        int count = 0;
        int num = 1;

        while (high != 0 || cur != 0) {
            cur = high % 10;
            high /= 10;

            //这里我们可以提出 high * num 因为我们发现无论为几，都含有它
            if (cur == 0) count += high * num;
            else if (cur == 1) count += high * num + 1 + low;
            else count += (high + 1) * num;

            //低位
            low = cur * num + low;
            num *= 10;
        }
        return count;
    }


    public  static int countDigitOne1(int n) {
        // "1"出现的次数 = sum ("1"在各个计数位上出现的次数)
        // 从个位开始向最高位统计
        // 3101592
        // 将数字拆分为[a...][cur][b...]
        // cur 为当前位

        long base = 1, res = 0;
        while (base <= n) {
            // 计算 a..., cur, b...
            long a, cur, b;
            a = n / base / 10;
            cur = (n / base) % 10;
            b = n % base;
            // 将当前位设为1，考察其他部分的变化范围

            // 一、cur > 1，
            // [3101 ] 5 [92]
            // 变化范围：[0-3101] 1 [0-99]
            // 总个数： (a+1) * base
            if (cur > 1) {res += (a + 1) * base;}

            // 二、cur == 1，
            // [310] 1 [592]
            // 1、变化范围 [0-309] 1 [0-999]
            // a * base
            // 2、变化范围 [310] 1 [0-592]
            // 1 * (b+1)
            // 总个数：a *base + (b + 1)
            else if (cur == 1) {res += a*base + b + 1;}

            // 三、cur < 1，
            // [31] 0 [1592]
            // 变化范围 [0-30] 1 [0-9999]
            // 总个数 a * base
            else {res += a * base;}

            // 统计更高一位
            base *= 10;
        }
        return (int) res;
    }

    public static void main(String[] args) {

        System.out.println(countDigitOne1(12));
    }
}
