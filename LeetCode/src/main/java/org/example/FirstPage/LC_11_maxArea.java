package org.example.FirstPage;

// 11、盛最多水的容器

//在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度−1 变短：
//若向内移动短板，水槽的短板 min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。


//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
public class LC_11_maxArea {
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;

        while (i < j ){
            if(height[i] < height[j]){
                res = Math.max(res, (j-i) * height[i]);
                i++;
            }
           else{
                res = Math.max(res,(j-i) * height[j]);
                j--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int [] nums =new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
