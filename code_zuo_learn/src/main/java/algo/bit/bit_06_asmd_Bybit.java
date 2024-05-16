package algo.bit;

public class bit_06_asmd_Bybit {

    public static int add(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static int subtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }

    public static int multiply(int a, int b) {
        int result = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                result = add(result, a);
            }
            a = a << 1;
            b = b >> 1;
        }
        return result;
    }

    public static int divide(int dividend, int divisor) {
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long quotient = 0;
        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            long multiple = 1;
            while ((temp << 1) <= absDividend) {
                temp <<= 1;
                multiple <<= 1;
            }
            absDividend -= temp;
            quotient += multiple;
        }

        if (sign == -1) {quotient = -quotient;}


        //请注意，对于除法运算，代码中使用了类型转换来处理整数溢出的情况，并限制了结果在Integer.MIN_VALUE和Integer.MAX_VALUE之间。
        return (int) Math.min(Math.max(quotient, Integer.MIN_VALUE), Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        int addition = add(a, b);
        int subtraction = subtract(a, b);
        int multiplication = multiply(a, b);
        int division = divide(a, b);

        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + division);
    }
}
