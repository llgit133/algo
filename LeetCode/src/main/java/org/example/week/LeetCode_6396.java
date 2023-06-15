package org.example.week;

public class LeetCode_6396 {

    public static int count(String num1, String num2, int min_sum, int max_sum) {

        int a = Integer.valueOf(num1);
        int b = Integer.valueOf(num2);

        int count = 0;
        while (a <= b){
            System.out.print(" "+ a);
            if(min_sum <= digit_sum(a)  &&  digit_sum(a) <= max_sum){count++;}
            a++;
        }
        return count;
    }

    public static int digit_sum(int number){
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(count("1", "5", 1, 5));
    }
}
