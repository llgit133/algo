package org.example.think_0_train;

public class BiraySearch {


    // 1、
    public static int basic1_fun(int [] arr,int target){

        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right -left) / 2;
            if (arr[mid] > target) right = mid -1;
            else if(arr[mid] < target) left = mid + 1;
            else return mid;
        }

        return -1;
    }

    //2、
    public static int basic2_fun(int [] arr,int target){

        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            int mid = left + (right -left) / 2;
            if (arr[mid] > target) right = mid;
            else if(arr[mid] < target) left = mid + 1;
            else return mid;
        }

        return -1;
    }


    //3、查找第一个值等于给定值的元素
    public static int left_fun(int [] arr,int target){

        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right -left) / 2;

            if(arr[mid] == target){
                if(arr[mid-1] !=target || mid == 0) return mid;
                else right = mid -1;
            }
            else if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    //4、查找最后一个值等于给定值的元素
    public static int right_fun(int [] arr,int target){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right -left) / 2;
            if(arr[mid] == target) {
                if(arr[mid + 1] != target || mid == arr.length -1) return mid;
                else mid = left + 1;
            }

            else if(arr[mid] > target)  right = mid -1;
            else left = mid + 1;
        }

        return -1;
    }

    //5、查找第一个大于等于给定值的元素
    public static int lg_fun(int [] arr,int target){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right -left) / 2;
            if(arr[mid] >= target) {
                if (arr[mid - 1] < target || mid == 0) return mid;
                else right = mid - 1;
            }
            else left = mid + 1;
        }
        return -1;
    }

    //6、查找最后一个小于等于给定值的元素
    public static int lt_fun(int [] arr, int target){

        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = left + (right -left) / 2;
            if(arr[mid] <= target) {
                if (arr[mid + 1] > target || mid == arr.length - 1) return mid;
                else left = mid + 1;
            }
            else right = mid - 1;
        }

        return -1;
    }




    public static void main(String[] args) {
        
        int [] arr = new int[]{2,3,4,5,5,6,7,7,7,9,10};
        System.out.println(basic1_fun(arr,3));
        System.out.println(basic2_fun(arr,3));
        System.out.println(left_fun(arr, 7));
        System.out.println(right_fun(arr, 7));
        System.out.println(lg_fun(arr, 8));
        System.out.println(lt_fun(arr, 8));
    }
}
