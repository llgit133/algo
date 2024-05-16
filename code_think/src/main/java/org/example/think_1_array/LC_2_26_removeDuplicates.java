package org.example.think_1_array;


//26. 删除有序数组中的重复项  返回新数组的长度

//输入：nums = [1,1,2]
//输出：2, nums = [1,2,_]
//解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。

//示例 2：
//输入：nums = [0,0,1,1,1,2,2,3,3,4]
//输出：5, nums = [0,1,2,3,4]
//解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素
public class LC_2_26_removeDuplicates {


    // 本质还是双指针 a 和 i
    public static int removeDuplicates(int[] nums) {
        int a = 0;

        //遍历，上下两位数不同时，按顺序给数组赋值
        for (int i = 0; i < nums.length -1; i++) {

            if(nums[i] != nums[i + 1]){
                nums[a] = nums[i + 1];
                a ++;
            }
        }

        // 返回长度
        return a + 1;
    }


    public static void main(String[] args) {

        int [] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
