package com.liao.cs_05_Array;


public class Array {

    public int data[];    //定义整型数据data保存数据
    private int n;        //定义数组长度
    private int count;    //定义中实际个数  count 不等于data.length吗？


    //构造方法，定义数组大小
    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;//一开始一个数都没有存所以为0
    }

    //根据索引，找到数据中的元素并返回
    public int find(int index){
        if (index < 0 || index >= count) return -1;
        return data[index];
    }

    //插入元素:头部插入，尾部插入
    public boolean insert(int index, int value){

        // 数组空间已满
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }
        // 位置不合法
        if (index < 0||index > count ) {
            System.out.println("位置不合法");
            return false;
        }
        // 位置合法、数组元素前移
        for( int i = count; i > index; --i){
            data[i] = data[i - 1];
        }

        data[index] = value;   //赋值
        ++count;
        return true;
    }

    //根据索引，删除数组中元素
    public boolean delete(int index){
        if (index<0 || index >=count) return false;

        //从删除位置开始，将后面的元素向前移动一位
        for (int i=index+1; i<count; ++i){
            data[i-1] = data[i];
        }
        --count;
        return true;
    }

    // 遍历
    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
//        array.insert(3, 11);
        array.printAll();
    }
}
