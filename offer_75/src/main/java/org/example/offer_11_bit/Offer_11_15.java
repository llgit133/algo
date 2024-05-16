package org.example.offer_11_bit;

//统计1的个数
public class Offer_11_15 {

    // 求出32位的二进制，统计1的个数
    public static int hammingWeight(int n) {

        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >=0; i--) {
            String s = (n & (1 << i)) == 0 ? "0" : "1";
            sb.append(s);
        }

        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(128));
    }
}
