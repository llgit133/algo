package org.example.think_3_hash;

import java.util.HashSet;
import java.util.Set;

//快乐数
public class LC_3_202_isHappy {

    public static boolean isHappy(int n) {
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
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(isHappy(19));

    }
}
