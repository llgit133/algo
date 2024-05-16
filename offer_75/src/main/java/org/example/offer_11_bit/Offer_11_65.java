package org.example.offer_11_bit;

// 位运算求和
public class Offer_11_65 {

    public static int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(3, 1));
    }
}
