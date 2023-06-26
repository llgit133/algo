package org.example.offer_7_tree_backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


//剑指 Offer 38. 字符串的排列
//输入一个字符串，打印出该字符串中字符的所有排列。
public class Offer_7_38 {

    //为了让递归函数添加结果方便，定义到函数之外，这样无需带到递归函数的参数列表中
    static List<String> list = new ArrayList<String>();

    //同；但是其赋值依赖c，定义声明分开
    static char[] c;


    public static String[] permutation(String s) {
        c = s.toCharArray();
        //从第一层开始递归
        dfs(0);

        //将字符串数组ArrayList转化为String类型数组
        return list.toArray(new String[list.size()]);
    }

    private static void dfs(int x) {
        //当递归函数到达第三层，就返回，因为此时第二第三个位置已经发生了交换
        if (x == c.length - 1) {
            //将字符数组转换为字符串
            list.add(String.valueOf(c));
            return;
        }
        
        //为了防止同一层递归出现重复元素
        HashSet<Character> set = new HashSet<>();

        //这里就很巧妙了,第一层可以是a,b,c那么就有三种情况，这里i = x,正巧dfs(0)，正好i = 0开始
        // 当第二层只有两种情况，dfs(1）i = 1开始
        for (int i = x; i < c.length; i++){
            //发生剪枝，当包含这个元素的时候，直接跳过
            if (set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            swap(i,x);
            dfs(x + 1);
            swap(i,x);
        }
    }

    private static void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }


    public static void main(String[] args) {

        String[] abcs = permutation("abc");
        for (String abc : abcs) {
            System.out.print(" "+abc);
        }
    }
}
