package algo.bit;

public class bit_01_Print32bit {



    // 左移 然后再&操作
    public static void Print_Int(int num) {
        for (int i = 31; i >= 0; i--) {

            //表达式 "num & (1 << i)" 是一个位运算操作，用于检查在二进制表示中的一个特定位是否被设置为 1
            //"<<" 是位左移运算符，将一个数的二进制表示向左移动指定的位数。
            //"1 << i" 表示将数字 1 的二进制表示向左移动 i 位。
            //"&" 是位 与运算符，对两个数的二进制表示进行位 与操作。

            String s = (num & (1 << i)) == 0 ? "0" : "1";
            System.out.print(s);
        }
        System.out.println();
    }
    public static void main(String[] args) {



        Print_Int(12);
        Print_Int(1);
//        Print_Int(2);
//        Print_Int(1 | 2);
//        Print_Int(1 & 2);
//        Print_Int(1 ^ 2);
//        Print_Int(-1);


//        int b = 1324871;
//        int c = ~b;
//        Print_Int(b);
//        Print_Int(c);
//        Print_Int(-5);

        //-32768
//        Print_Int(Integer.MIN_VALUE);
//        Print_Int(Integer.MAX_VALUE);

        // 负数补码的右移
//        int d = Integer.MIN_VALUE;
//        Print_Int(d);
//        Print_Int(d >> 1); // 带符号右移动
//        Print_Int(d >>> 1); // 不带符号右移


//        int e = 5;
//        int f = -5;
//        f = ~ e + 1 ; // 取反再加1
//        System.out.println(e);
//        System.out.println(f);


        // 理解 负数就是取反再加1
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(~Integer.MIN_VALUE + 1);
//        System.out.println(-Integer.MIN_VALUE);
    }
}
