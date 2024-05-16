package org.example.think_3_hash;

import java.util.HashSet;
import java.util.Set;

//快乐数
//「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
// 如果 可以变为  1，那么这个数就是快乐数。



//输入：19
//输出：true

//1^2 + 9^2 = 82
//8^2 + 2^2 = 68
//6^2 + 8^2 = 100
//1^2 + 0^2 + 0^2 = 1

public class LC_3_202_isHappy {

    public static boolean isHappy(int n) {

        // 避免重复的数据
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private static int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res = res + temp * temp;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(isHappy(19));

    }
}
